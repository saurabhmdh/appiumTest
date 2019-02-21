package com.android.automation.daigModule;

import com.android.automation.data.AutoTestData;
import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

import java.util.Arrays;
import java.util.List;
import java.util.Map;


public class AutoTestCases implements ItestSuite {

    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... Auto Test Cases");
        //System.out.println("AutoTestData.getInstance().getALLAutoTestCases() >> " + AutoTestData.TData);

        for (AutoTestData.TData data : AutoTestData.getInstance().getALLAutoTestCases()) {
            System.out.println("Running..... Auto Test Cases --> " + data.getTestID());
            List<String> launchArgs = Arrays.asList("start -n " + Constants.PACKAGE + "/" + Constants.LAUNCHER_ACTIVITY
                    + " --es \"type\" \"" + data.getTestID() + "\" --es \"sessId\" \" " + Constants.SESSION_ID + "\"");
            Map<String, Object> launchArgsCmd = ImmutableMap.of("command", "am", "args", launchArgs);
            driver.executeScript("mobile: shell", launchArgsCmd);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            // TODO: Need to sepertae screenshot code from auto test cases
            TestSuite.captureScreenshot(data.getTestID());
            TestSuite.getInstance().addResult(data.getTestID(), null);
        }

        return Constants.Result.PASS;

    }

    @Override
    public String getOriginalName() {
        return null;
    }

}
