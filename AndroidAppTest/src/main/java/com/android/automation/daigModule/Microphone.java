package com.android.automation.daigModule;

import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.android.automation.utils.UtilCommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class Microphone implements ItestSuite {

    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... Microphone Test");
        driver.executeScript("mobile: shell", UtilCommon.commandGenerator(Constants.MICROPHONE));

        if (expectedOutput == 2) {
            try {
                TestSuite.captureScreenshot(Constants.MICROPHONE);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_SKIP).click();
                TestSuite.captureScreenshot(Constants.MICROPHONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (expectedOutput == -1) {
            System.out.println("Unsupported Case");
        } else if (expectedOutput == 0) {
            try {
                TestSuite.captureScreenshot(Constants.MICROPHONE);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.MICROPHONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.MICROPHONE);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_NO).click();
                TestSuite.captureScreenshot(Constants.MICROPHONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                TestSuite.captureScreenshot(Constants.MICROPHONE);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.MICROPHONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.MICROPHONE);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_PLAY).click();
                TestSuite.captureScreenshot(Constants.MICROPHONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(4000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.MICROPHONE);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_PLAY).click();
                TestSuite.captureScreenshot(Constants.MICROPHONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.MICROPHONE);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.MICROPHONE);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TestSuite.getInstance().addResult(getOriginalName(), null);
        return Constants.Result.PASS;
    }

    @Override
    public String getOriginalName() {
        return Constants.MICROPHONE;
    }
}
