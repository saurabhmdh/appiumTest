package com.android.automation.utils;

import com.android.automation.data.InputData;
import com.android.automation.data.TestData;
import com.android.automation.interfaces.ItestSuite;
import com.google.common.collect.ImmutableMap;
import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.logging.LogEntry;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class UtilCommon {

    public static Object createObject(String className) {
        Object object = null;
        try {
            Class classDefinition = Class.forName(className);
            object = classDefinition.newInstance();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
            System.out.println(e);
        }
        return object;
    }

    public static int getValueFromLog(List<LogEntry> adbLogs, String type) {
        for (LogEntry log : adbLogs) {
            if (log.getMessage().contains(Constants.RESULT_PATTERN + "{")) {
                if (!log.getMessage().contains(type)) {
                    continue;
                }
                System.out.println(log.getMessage());
                int index = log.getMessage().indexOf(Constants.RESULT_PATTERN) + Constants.RESULT_PATTERN.length();
                String jsonStr = log.getMessage().substring(index);
                JSONObject jsonObj;
                System.out.println(jsonStr);
                try {
                    jsonObj = new JSONObject(jsonStr);
                    return jsonObj.getInt("result");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //System.out.println("log result : " + result);
            }
        }
        return Constants.result;
    }

    public static boolean isAdded(List<TestData> data) {
        if (data.isEmpty()) return false;

        for (TestData it : data) {
            if (it.getItestSuite().getClass().getSimpleName().contains(Constants.AutoTestCases)) {
                return true;
            }
        }
        return false;
    }

    public static TestData addAutoTestCase(InputData input) {
        ItestSuite testClass = (ItestSuite) UtilCommon.createObject(Constants.PACKAGE_PREFIX + Constants.AutoTestCases);
        Constants.TestDecision decision = "1".equals(input.isExecutable()) ? Constants.TestDecision.RUN : Constants.TestDecision.SKIP;
        int expected = Integer.valueOf(input.getExpectedResult());
        return new TestData(input.getTestCase(), decision, testClass, expected);
    }

    public static int getExpectedValue(String keys, List<TestData> data) {
        for (TestData input : data) {
            if (input.getDiagnosis().equals(keys)) {
                return input.getExpectedOutput();
            }
        }
        return 1;
    }

    public static Map<String, Object> commandGenerator(String key) {
        List<String> launchArgs = Arrays.asList("start -n " + Constants.PACKAGE + "/" + Constants.LAUNCHER_ACTIVITY
                + " --es \"type\" \"" + key + "\" --es \"sessId\" \" " + Constants.SESSION_ID + "\"");
        Map<String, Object> launchArgsCmd = ImmutableMap.of("command", "am", "args", launchArgs);
        return launchArgsCmd;
    }

    public static void Sleep(int time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static Constants.Result getResultType(int fromLog, int fromText) {
        if (fromLog != fromText) {
            return Constants.Result.FAIL;
        }
        if (fromText == 2) {
            return Constants.Result.SKIP;
        }
        if (fromText == -1) {
            return Constants.Result.UNSUPPORTED;
        }
        return Constants.Result.PASS;
    }
}
