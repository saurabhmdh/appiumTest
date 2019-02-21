package com.android.automation.daigModule;

import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.android.automation.utils.UtilCommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class Fingerprint implements ItestSuite {

    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... Back Key Test");
        driver.executeScript("mobile: shell", UtilCommon.commandGenerator(Constants.FINGERPRINT));

        if (expectedOutput == 2) {
            try {
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_SKIP).click();
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (expectedOutput == -1) {
            TestSuite.captureScreenshot(Constants.FINGERPRINT);
            driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
        } else if (expectedOutput == 0) {
            try {
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_NO).click();
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement ele = driver.findElementById(Constants.PACKAGE + Constants.BTN_YES);
            if (ele.isEnabled()) {
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.FINGERPRINT);
            }
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        TestSuite.getInstance().addResult(getOriginalName(), null);
        return Constants.Result.PASS;
    }

    @Override
    public String getOriginalName() {
        return Constants.FINGERPRINT;
    }

}
