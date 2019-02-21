package com.android.automation.daigModule;


import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.android.automation.utils.UtilCommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CamFrontVideo implements ItestSuite {

    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... Front Camera Video Test");
        driver.executeScript("mobile: shell", UtilCommon.commandGenerator(Constants.FRONT_CAMERA_VIDEO));

        if (expectedOutput == 2) {
            try {
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_SKIP).click();
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (expectedOutput == -1) {
            System.out.println("Unsupported Case");
        } else if (expectedOutput == 0) {
            try {
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_CAPTURE).click();
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_NO).click();
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_CAPTURE).click();
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.FRONT_CAMERA_VIDEO);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TestSuite.getInstance().addResult(getOriginalName(), null);
        return Constants.Result.PASS;
    }

    @Override
    public String getOriginalName() {
        return Constants.FRONT_CAMERA_VIDEO;
    }
}