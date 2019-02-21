package com.android.automation.daigModule;

import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.android.automation.utils.UtilCommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;


public class UnifiedLcdDimming implements ItestSuite {

    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... Unified LCD Dimming Test");
        TouchAction touchAction = new TouchAction(driver);
        driver.executeScript("mobile: shell", UtilCommon.commandGenerator(Constants.UNIFIED_LCD_DIMMING));

        if (expectedOutput == 2) {
            try {
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_SKIP).click();
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (expectedOutput == -1) {
            System.out.println("Unsupported Case");
        } else if (expectedOutput == 0) {
            try {
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_NO).click();
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            touchAction.tap(PointOption.point(230, 400)).perform();
            TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.UNIFIED_LCD_DIMMING);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        TestSuite.getInstance().addResult(getOriginalName(), null);
        return Constants.Result.PASS;

    }

    @Override
    public String getOriginalName() {
        return Constants.UNIFIED_LCD_DIMMING;
    }
}
