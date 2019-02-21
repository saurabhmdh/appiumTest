package com.android.automation.daigModule;

import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;
import com.android.automation.utils.UtilCommon;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;

public class Touchscreen implements ItestSuite {
    @Override
    public Constants.Result execute(AppiumDriver<MobileElement> driver, int expectedOutput) {
        System.out.println("Running..... TouchScreen Test");
        driver.executeScript("mobile: shell", UtilCommon.commandGenerator(Constants.TOUCH));

        if (expectedOutput == 2) {
            try {
                TestSuite.captureScreenshot(Constants.TOUCH);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_SKIP).click();
                TestSuite.captureScreenshot(Constants.TOUCH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (expectedOutput == -1) {
            System.out.println("Unsupported Case");
        } else if (expectedOutput == 0) {
            try {
                TestSuite.captureScreenshot(Constants.TOUCH);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.TOUCH);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.TOUCH);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_NO).click();
                TestSuite.captureScreenshot(Constants.TOUCH);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            try {
                TestSuite.captureScreenshot(Constants.TOUCH);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.TOUCH);
            } catch (Exception e) {
                e.printStackTrace();
            }
            // TODO: Tap in last line on the device screen due to android botton status bar

            Dimension windowSize = driver.manage().window().getSize();
            int height = windowSize.getHeight();
            int width = windowSize.getWidth();

            int boxHeight = Math.abs(height / Constants.ROW);
            int boxWidth = Math.abs(width / Constants.COLUMN);
            int midHeight = boxHeight / 2;

            for (int i = 0; i < Constants.ROW; i++) {
                int midWidth = boxWidth / 2;
                for (int j = 0; j < Constants.COLUMN; j++) {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    TouchAction touchAction = new TouchAction(driver);
                    touchAction.tap(PointOption.point(midWidth, midHeight)).perform();
                    midWidth += boxWidth;
                }
                midHeight += (boxHeight + 3);
            }
            try {
                Thread.sleep(2000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            try {
                TestSuite.captureScreenshot(Constants.TOUCH);
                driver.findElementById(Constants.PACKAGE + Constants.BTN_YES).click();
                TestSuite.captureScreenshot(Constants.TOUCH);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        TestSuite.getInstance().addResult(getOriginalName(), null);
        return Constants.Result.PASS;

    }

    @Override
    public String getOriginalName() {
        return Constants.TOUCH;
    }

}
