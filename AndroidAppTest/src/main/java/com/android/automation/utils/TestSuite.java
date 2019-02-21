package com.android.automation.utils;

import com.android.automation.data.*;
import com.android.automation.interfaces.ItestSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.text.WordUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class TestSuite {

    private static Map<String, Map<String, String>> screenShotFilePathMap = new LinkedHashMap<>();

    private static AppiumDriver<MobileElement> driver;

    private static TestSuite single_instance = new TestSuite();

    private Map<String, ResultData> resultList = Collections.synchronizedMap(new LinkedHashMap<>());

    private AutoTestData mAutoTestData = AutoTestData.getInstance();

    private TestSuite() {
    }

    public static String getCurrentTime() {
        return driver.getDeviceTime();
    }

    public static TestSuite getInstance() {
        return single_instance;
    }

    public static void captureScreenshot(String key) {
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(Constants.RESULT_DIRECTORY_PATH);
        reporter.config().enableTimeline(true);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        ExtentTest finger = extent.createTest(key);
        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String destDir = Constants.SCREENSHOT_DIRECTORY;
        SimpleDateFormat dateFormat = new SimpleDateFormat(Constants.DATE_FORMAT);
        new File(destDir).mkdirs();
        String destFile = dateFormat.format(new Date()) + Constants.SCREENSHOT_FILE_FORMAT;
        try {
            FileUtils.copyFile(scrFile, new File(Constants.SCREENSHOT_DIRECTORY_PATH + destFile));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String fileName = "Screenshot_" + destFile;
        String fileTag = "<img class='r-img' onerror='this.style.display=\"none\"' " +
                "height=\"300\" data-featherlight='./" + fileName + "'" + "src='./" + fileName + "'" + "data-src='./" + fileName + "'>";
        finger.log(Status.INFO, fileTag);
        Map stored = screenShotFilePathMap.get(key);
        if (stored != null) {
            stored.put(key + stored.size(), fileTag);
        } else {
            stored = new LinkedHashMap<String, String>();
            stored.put(key + stored.size(), fileTag);
        }
        screenShotFilePathMap.put(key, stored);
    }

    public static Properties readConfigFile() {

        Properties prop = new Properties();
        FileInputStream ip = null;
        {
            try {
                ip = new FileInputStream(Constants.CONFIG_FILE_PATH);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            try {
                prop.load(ip);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return prop;
    }

    private AppiumDriver<MobileElement> getDriver() {
        return driver;
    }

    private List<LogEntry> getLog() {
        return getDriver().manage().logs().get("logcat").getAll();
    }

    private void init(String deviceId, String platformVersion) {

        DesiredCapabilities caps = getCapabilities(deviceId, platformVersion);
        try {
            driver = new AndroidDriver<MobileElement>(new URL(Constants.URL), caps);
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.manage().logs().get("logcat");


        } catch (Exception e) {
            System.out.println("Mobile is not connected... ");
        }

    }

    //Android Capabilities
    private DesiredCapabilities getCapabilities(String deviceId, String platformVersion) {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", Constants.DEVICE_NAME);
        caps.setCapability("udid", deviceId);
        caps.setCapability("platformVersion", platformVersion);
        caps.setCapability("appPackage", Constants.PACKAGE);
        caps.setCapability("appActivity", Constants.LAUNCHER_ACTIVITY);
        caps.setCapability("autoGrantPermissions", true);
        caps.setCapability("noReset", "true");
        caps.setCapability("unlockType", "pin");
        caps.setCapability("unlockKey", "1111");
        caps.setCapability("newCommandTimeout", "10");
        caps.setCapability("automationName", Constants.AUTOMATION_NAME);
        caps.setCapability("relaxedSecurity", true);
        return caps;
    }

    private List<InputData> readTestCaseFile(String fileName) {
        List<InputData> result = new ArrayList<>();
        try {
            File file = new File(fileName);
            System.out.println("File exists ? = " + file.exists());
            BufferedReader br = new BufferedReader(new FileReader(file));

            String st;
            while ((st = br.readLine()) != null) {
                if (st.startsWith("//")) {
                    continue;
                }
                String[] splitValue = st.split(" ");
                result.add(new InputData(splitValue[0], splitValue[1], splitValue[2]));
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Unable to find " + fileName);
        }
        return result;
    }

    private List<InputData> fileTestCase(String filename) {
        List<InputData> result = new ArrayList<>();
        final Path path = FileSystems.getDefault().getPath(filename);
        try (final BufferedReader r = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line = null;
            while ((line = r.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Unable to find " + path.toString());
        }
        return result;
    }

    public void executeTest(String filePath, String deviceId, String platfromVersion) {
        //First Execute init
        init(deviceId, platfromVersion);

        List<TestData> data = collectTestData(filePath);
        executeAllTest(data);

        UtilCommon.Sleep(2000);
        readAllLogs(data);
        printResult();
    }

    private List<TestData> collectTestData(String file) {
        List<InputData> inputs = readTestCaseFile(file);
        List<TestData> data = new ArrayList<>();

        for (InputData input : inputs) {
            //Auto case -> it can contains multiple entries..
            if (Constants.sLookup.contains(input.getTestCase())) {
                if (!"1".equals(input.isExecutable())) {
                    continue;
                }
                mAutoTestData.addTestEntry(new AutoTestData.TData(input.getTestCase(), input.getExpectedResult()));
                if (!UtilCommon.isAdded(data)) {
                    data.add(UtilCommon.addAutoTestCase(input));
                }
                continue;
            }
            String className = WordUtils.capitalizeFully(input.getTestCase(), '_').replaceAll("_", "");
            ItestSuite testClass = (ItestSuite) UtilCommon.createObject(Constants.PACKAGE_PREFIX + className);
            Constants.TestDecision decision = "1".equals(input.isExecutable()) ? Constants.TestDecision.RUN : Constants.TestDecision.SKIP;

            int expected = Integer.valueOf(input.getExpectedResult());
            data.add(new TestData(testClass.getOriginalName(), decision, testClass, expected));
        }

        return data;
    }

    private void executeAllTest(List<TestData> inputs) {

        for (int i = 0; i < inputs.size(); i++) {
            TestData data = inputs.get(i);
            if (data.getDecision() == Constants.TestDecision.RUN) {
                try {
                    Constants.Result result = data.getItestSuite().execute(getDriver(), data.getExpectedOutput());
                    data.setResultIdentifer(result);
                } catch (Exception e) {
                    System.out.println("Exception on case : " + data.getItestSuite());
                    data.setResultIdentifer(Constants.Result.FAIL);
                }
            }
            LogCollector.getInstance().parseLog(getLog());
        }
    }

    private void printResult() {
        System.out.println("----------------------------Result------------------------------");
        ExtentHtmlReporter reporter = new ExtentHtmlReporter(Constants.RESULT_DIRECTORY_PATH);
        reporter.config().enableTimeline(true);
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);

        for (String key : resultList.keySet()) {
            System.out.println(resultList.get(key).getType() + " >> " + resultList.get(key).getResult());
            ExtentTest finger = extent.createTest(resultList.get(key).getType());
            for (Map.Entry<String, String> entry : screenShotFilePathMap.get(key).entrySet()) {
                //System.out.println(entry.getKey() + "/" + entry.getValue());
                finger.log(Status.INFO, entry.getValue());
            }
            switch (resultList.get(key).getResult()) {
                case PASS:
                    finger.log(Status.PASS, "result" + resultList.get(key).getResult());
                    break;
                case UNSUPPORTED:
                    finger.log(Status.WARNING, "result" + resultList.get(key).getResult());
                    break;
                case FAIL:
                    finger.log(Status.FAIL, "result" + resultList.get(key).getResult());
                    break;
                case SKIP:
                    finger.log(Status.SKIP, "result" + resultList.get(key).getResult());
                    break;
            }
        }
        extent.flush();
    }

    public void addResult(String key, ResultData result) {
        resultList.put(key, result);
    }

    private void readAllLogs(List<TestData> data) {
        List<LogEntry> adbLogs = LogCollector.getInstance().getAllLog();

        for (String keys : resultList.keySet()) {
            ResultData resultData = new ResultData();
            int result = UtilCommon.getValueFromLog(adbLogs, keys);
            //Check with expected value....
            if (Constants.sLookup.contains(keys)) {
                resultData.setResult(UtilCommon.getResultType(Integer.valueOf(mAutoTestData.find(keys).getExpected()), result));
            } else {
                //Get the Expected for normal case
                resultData.setResult(UtilCommon.getResultType(UtilCommon.getExpectedValue(keys, data), result));
            }
            resultData.setType(keys);
            resultList.put(keys, resultData);
        }
    }

}


