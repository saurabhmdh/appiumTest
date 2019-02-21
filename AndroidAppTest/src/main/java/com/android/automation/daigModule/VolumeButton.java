package com.android.automation.daigModule;

import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.android.automation.utils.UtilCommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;

public class VolumeButton implements ItestSuite {
    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... Volume Button Test");
        driver.executeScript("mobile: shell", UtilCommon.commandGenerator(Constants.VOLUME_KEY));

        if (expectedOutput == 2) {
            try {
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_SKIP).click();
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (expectedOutput == -1) {
            System.out.println("Unsupported Case");
        } else if (expectedOutput == 0) {

            try {
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_NO).click();
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {

            try {
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);

            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
                ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.VOLUME_UP));
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
                ((PressesKey) driver).pressKey(new KeyEvent(AndroidKey.VOLUME_DOWN));
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.VOLUME_KEY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TestSuite.getInstance().addResult(getOriginalName(), null);

        return Constants.Result.PASS;
    }

    @Override
    public String getOriginalName() {
        return Constants.VOLUME_KEY;
    }


}
