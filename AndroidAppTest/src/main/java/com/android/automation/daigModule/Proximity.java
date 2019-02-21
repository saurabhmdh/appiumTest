package com.android.automation.daigModule;

import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.android.automation.utils.UtilCommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.WebElement;

public class Proximity implements ItestSuite {

    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... Proximity Test");
        driver.executeScript("mobile: shell", UtilCommon.commandGenerator(Constants.PROXIMITY));

        if (expectedOutput == 2) {
            try {
                TestSuite.captureScreenshot(Constants.PROXIMITY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_SKIP).click();
                TestSuite.captureScreenshot(Constants.PROXIMITY);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (expectedOutput == -1) {
            System.out.println("Unsupported Case");
        } else if (expectedOutput == 0) {
            try {
                TestSuite.captureScreenshot(Constants.PROXIMITY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.PROXIMITY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.PROXIMITY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_NO).click();
                TestSuite.captureScreenshot(Constants.PROXIMITY);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                TestSuite.captureScreenshot(Constants.PROXIMITY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.PROXIMITY);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            WebElement ele = driver.findElementById(Constants.PACKAGE + Constants.BTN_YES);
            if (ele.isEnabled()) {
                TestSuite.captureScreenshot(Constants.PROXIMITY);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.PROXIMITY);
            }
        }
        TestSuite.getInstance().addResult(getOriginalName(), null);
        return Constants.Result.PASS;

    }

    @Override
    public String getOriginalName() {
        return Constants.PROXIMITY;
    }

}
