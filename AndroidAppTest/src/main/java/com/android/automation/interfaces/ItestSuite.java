package com.android.automation.interfaces;

import com.android.automation.utils.Constants.Result;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public interface ItestSuite {
    Result execute(AppiumDriver<MobileElement> driver, int expectedOutput);

    String getOriginalName();
}
