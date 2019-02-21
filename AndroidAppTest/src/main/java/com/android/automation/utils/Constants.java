package com.android.automation.utils;

import com.android.automation.test.AppAuto;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class Constants {


    // 1:Pass / 0:fail / 2:skipped / -1: unsupported
    public static final String SESSION_ID = UUID.randomUUID().toString();
    public static final String URL = "http://127.0.0.1:4723/wd/hub";
    public static final String PACKAGE = "XXX.devicediagnosis.XXXXXX";
    public static final String LAUNCHER_ACTIVITY = "XXX.XXXXXXXX.activity.XXXXXXXXXX";
    public static final String RESULT_PATTERN = "+result+";
    public static final String PACKAGE_PREFIX = "com.android.automation.daigModule.";
    public static final String DEVICE_NAME = "Android";
    public static final String AUTOMATION_NAME = "UiAutomator";
    public static final String IOS_PACKAGE = "XXXXXXXX.inhouse";
    public static final String SCREENSHOT_DIRECTORY = "build/libs/reports";
    public static final String SCREENSHOT_DIRECTORY_PATH = "./reports/Screenshot_";
    public static final String DATE_FORMAT = "dd-MMM-yyyy__hh:mm:ss aa";
    public static final String SCREENSHOT_FILE_FORMAT = ".png";
    public static final String REPORT_FILE_FORMAT = ".html";
    public static final String BTN_SKIP = ":id/btn_skip";
    public static final String BTN_NO = ":id/btn_no";
    public static final String BTN_YES = ":id/btn_yes";
    public static final String BTN_CAPTURE = ":id/button_capture";
    public static final String BTN_PLAY = ":id/btn_play";
    public static final String CELLULAR_CALL_BTN_OK = ":id/button1";
    public static final String CELLULAR_CALL_BTN_CANCEL = ":id/button2";
    public static final String ALLOW_BTN = "com.android.packageinstaller:id/permission_allow_button";
    public static final String CELLULAR_NETWORK_OK = "android:id/button1";
    public static final String IMAGE_VERSION_CMD = "adb shell getprop ro.build.display.id";
    public static final String SEE_IP_ADDRESS_CMD = "adb shell ifconfig tiwlan0";
    public static final String CLEAR_APP_DATA_CMD = "adb shell pm clear com.devicediagnosis.XXXXXXXX";
    public static final String FILTER_LOGS_FOR_ERRORS = "adb logcat *:E";
    public static final String CREATE_LOG_FILES_WITHJUST_ERRORS = "adb logcat *:E > errorLog.txt";
    public static final String RECORD_SCREEN = "adb shell screenrecord \"/path/to/record.mp4\"";
    public static final String TAKE_SCREENSHOT = "adb shell screencap -p | perl -pe 's/\\x0D\\x0A/\\x0A/g' > screen.png";
    public static final String WIFI_ON_CMD = "adb shell am broadcast -a io.appium.settings.wifi -n io.appium.settings/.receivers.WiFiConnectionSettingReceiver --es setstatus enable";
    public static final String WIFI_OFF_CMD = "adb shell am broadcast -a io.appium.settings.wifi -n io.appium.settings/.receivers.WiFiConnectionSettingReceiver --es setstatus disable";
    public static final String AIRPLANE_MODE_ON_CMD = "adb shell settings put global airplane_mode_on 1";
    public static final String AIRPLANE_MODE_OFF_CMD = "adb shell settings put global airplane_mode_on 0";
    public static final String BLUETOOTH_TETHERING_CMD = "adb shell am start -n com.android.settings/.TetherSettings && adb shell input keyevent 20 && adb shell input keyevent 20 && adb shell input keyevent KEYCODE_ENTER && sleep 2 && adb shell input keyevent 4 3";
    public static final String WIFI_TETHERING_CMD = "adb shell am start -n com.android.settings/.TetherSettings && adb shell input keyevent 20 && adb shell input keyevent 20 && adb shell input keyevent KEYCODE_ENTER && sleep 2 && adb shell input keyevent 4 0";
    public static final String WIFI_TETHERING_OFF_CMD = "adb shell am start -n com.android.settings/.TetherSettings && adb shell input keyevent 20 && adb shell input keyevent 20 && adb shell input keyevent KEYCODE_ENTER && sleep 2 && adb shell input keyevent 4 2";
    public static final String NFC_ON_CMD = "";
    public static final String NFC_OFF_CMD = "";
    public static final String GPS_ON_CMD = "adb shell settings put secure location_providers_allowed +gps";
    public static final String GPS_OFF_CMD = "adb shell settings put secure location_providers_allowed -gps";
    public static final String MOBILE_NETWORK_ON_CMD = "adb shell settings put secure location_providers_allowed +network";
    public static final String MOBILE_NETWORK_OFF_CMD = "adb shell settings put secure location_providers_allowed -network";
    public static final String WIFI_STATUS_CMD = "adb shell am start -n com.android.settings/.wifi.WifiStatusTest";
    public static final String OPEN_DEV_OPTION = "adb shell am start -n com.android.settings/.DevelopmentSettings";
    public static final String DEVICE_LIST = "adb devices";
    public static final String GET_DEVICE_MODEL = "adb shell getprop ro.product.model";
    public static final String RESULT_DIRECTORY_PATH = "./reports/" + AppAuto.getModel() + "_" + AppAuto.getSerial() + "_" + TestSuite.getCurrentTime() + REPORT_FILE_FORMAT;
    public static final String GET_PLATFORM_VERSION = "adb shell getprop ro.build.version.release";
    public static final int COLUMN = 8;
    public static final int ROW = 13;
    public static final List<String> sLookup = Arrays.asList(
            "ambient_light",
            "gyroscope",
            "accelerometer",
            "magnetic_sensor",
            "barometer",
            "ambient_temperature",
            "relative_humidity",
            "sim_state",
            "radio_tech",
            "wifi_hw_support",
            "wifi_chipset_op",
            "tether_hw_support",
            "tether_chipset_op",
            "bt_hw_support",
            "bt_chipset_op",
            "gps_hw_support",
            "gps_coordinates",
            "nfc_hw_support",
            "batt_charging",
            "int_storage_rw",
            "sdcard_detect",
            "sdcard_rw",
            "last_restart",
            "ram_usage",
            "int_storage_capacity",
            "sdcard_storage_capacity",
            "wifi_status",
            "tether_status",
            "bt_status",
            "gps_status",
            "nfc_status",
            "brightness_setting",
            "livewallpaper_usage",
            "screen_timeout",
            "batt_discharge_check",
            "rooted",
            "batt_health",
            "mobile_data_conn",
            "lcd",
            "dimming",
            "firmware"
    );
    public static final String AutoTestCases = "AutoTestCases";
    public static final String EARPHONE = "headset_playback";
    public static final String EARPHONE_JACK = "headset_jack";
    public static final String SPEAKER = "speaker";
    public static final String MICROPHONE = "microphone";
    public static final String RECEIVER = "receiver";
    public static final String BATTERY_CHARGING = "batt_charging";
    public static final String BATTERY_HEALTH = "batt_health";
    public static final String CAMERA_FLASH = "cam_flash";
    public static final String FRONT_CAMERA_PICTURE = "cam_front_pic";
    public static final String FRONT_CAMERA_VIDEO = "cam_front_video";
    public static final String REAR_CAMERA_PICTURE = "cam_rear_pic";
    public static final String REAR_CAMERA_VIDEO = "cam_rear_video";
    public static final String BLUETOOTH_CHIP_OP = "bt_chipset_op";
    public static final String BLUETOOTH_HW = "bt_hw_support";
    public static final String BLUETOOTH_STATUS = "bt_status";
    public static final String GPS_COORDINATES = "gps_coordinates";
    public static final String GPS_HW = "gps_hw_support";
    public static final String GPS_STATUS = "gps_status";
    public static final String NFC_HW = "nfc_hw_support";
    public static final String NFC_STATUS = "nfc_status";
    public static final String TETHERING_STATUS = "tether_status";
    public static final String TETHERING_HW = "tether_hw_support";
    public static final String TETHERING_CHIPSET = "tether_chipset_op";
    public static final String WIFI_CHIP_OP = "wifi_chipset_op";
    public static final String WIFI_HW = "wifi_hw_support";
    public static final String WIFI_STATUS = "wifi_status";
    public static final String FINGERPRINT = "fingerprint";
    @Deprecated
    public static final String KEYS = "keys";
    public static final String POWER_KEY = "power_button";
    public static final String HOME_KEY = "home_button";
    public static final String VOLUME_KEY = "volume_button";
    public static final String BACK_KEY = "back_button";
    public static final String RECENT_KEY = "recent_key";
    public static final String VIBRATION = "vibration";
    public static final String INSTALLED_APPS_INFO = "apps_info";
    public static final String APPS_USAGE = "apps_usage";
    public static final String FIRMWARE = "firmware";
    public static final String LAST_RESTART = "last_restart";
    public static final String LIVE_WALLPAPER_USAGE = "livewallpaper_usage";
    public static final String RAM_USAGE = "ram_usage";
    public static final String ROOTED = "rooted";
    public static final String SCREEN_TIMEOUT = "screen_timeout";
    public static final String BRIGHTNESS = "brightness_setting";
    public static final String DIMMING = "dimming";
    public static final String LCD = "lcd";
    public static final String TOUCH = "touchscreen";
    public static final String ACCELEROMETER = "accelerometer";
    public static final String AMBIENT_LIGHT = "ambient_light";
    public static final String AMBIENT_TEMPERATURE = "ambient_temperature";
    public static final String BAROMETER = "barometer";
    public static final String GYROSCOPE = "gyroscope";
    public static final String MAGNETIC_SENSOR = "magnetic_sensor";
    public static final String RELATIVE_HUMIDITY = "relative_humidity";
    public static final String PROXIMITY = "proximity";
    public static final String SDCARD_READ_WRITE = "sdcard_rw";
    public static final String SDCARD_CAPACITY = "sdcard_storage_capacity";
    public static final String SDCARD_DETECT = "sdcard_detect";
    public static final String INT_STORAGE_READ_WRITE = "int_storage_rw";
    public static final String INT_STORAGE_CAPACITY = "int_storage_capacity";
    public static final String CALL = "call_op";
    public static final String MOBILE_DATA_CONN = "mobile_data_conn";
    public static final String MOBILE_RADIO_TECH = "radio_tech";
    public static final String SIM = "sim_state";
    public static final String UNIFIED_LCD_DIMMING = "unified_lcd_dimming";
    public static final String CONFIG_FILE_PATH = "./src/main/java/com/android/automation/utils/config.properties";
    public static final int result = -4;

    public enum Result {
        PASS, FAIL, SKIP, UNSUPPORTED
    }
    public enum TestDecision {
        RUN, SKIP
    }

    public enum ExpectedResult {
        FAIL, PASS, SKIP, UNSUPPORTED
    }
}
