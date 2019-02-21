package com.android.automation.test;

import com.android.automation.utils.Constants;
import com.android.automation.utils.TestSuite;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AppAuto {

    private static Properties properties;

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            throw new Exception("Length of the argument is " + args.length + ", Add testfile path as a argument");
        }
        properties = TestSuite.readConfigFile();
        wifiBasedOnConfig();
        Thread.sleep(2000);
        //bluetoothBasedOnConfig();
        //Thread.sleep(2000);
        gpsBasedOnConfig();
        Thread.sleep(2000);
        //mobileNetworkBasedOnConfig();
        //Thread.sleep(2000);
        TestSuite.getInstance().executeTest(args[0], getSerial(), getVersion());

    }

    public static String getSerial() {
        return runShellCmd(Constants.DEVICE_LIST).get(1).split("\t")[0];
    }

    public static String getModel() {
        return runShellCmd(Constants.GET_DEVICE_MODEL).get(0);
    }

    public static String getVersion() {
        return runShellCmd(Constants.GET_PLATFORM_VERSION).get(0);
    }

    public static boolean wifiEnabled() {
        return Boolean.parseBoolean(runShellCmd(Constants.WIFI_ON_CMD).get(0));
    }

    public static boolean wifiDisabled() {
        return Boolean.parseBoolean(runShellCmd(Constants.WIFI_OFF_CMD).get(0));
    }

    public static void wifiTetheringOn() {
        runShellCmd(Constants.WIFI_TETHERING_CMD);
    }

    public static void bluetoothEnabled() {
        runShellCmd(Constants.BLUETOOTH_TETHERING_CMD);
    }

    public static void bluetoothDisabled() {
        runShellCmd(Constants.BLUETOOTH_TETHERING_CMD);
    }

    public static void gpsDisabled() {
        runShellCmd(Constants.GPS_OFF_CMD);
    }

    public static void gpsEnabled() {
        runShellCmd(Constants.GPS_ON_CMD);
    }

    public static void mobileNetworkEnabled() {
        runShellCmd(Constants.MOBILE_NETWORK_ON_CMD);
    }

    public static void mobileNetworkDisabled() {
        runShellCmd(Constants.MOBILE_NETWORK_OFF_CMD);
    }

    public static void airplaneModeDisabled() {
        runShellCmd(Constants.AIRPLANE_MODE_OFF_CMD);
    }

    public static void airplaneModeEnabled() {
        runShellCmd(Constants.AIRPLANE_MODE_ON_CMD);
    }


    public static void wifiBasedOnConfig() {
        if (Integer.parseInt(properties.getProperty("WiFi")) == 0) {
            wifiDisabled();
        } else {
            wifiEnabled();
        }
    }

    public static void bluetoothBasedOnConfig() {
        if (Integer.parseInt(properties.getProperty("Bluetooth")) == 0) {
            bluetoothDisabled();
        } else {
            bluetoothEnabled();
        }
    }

    public static void gpsBasedOnConfig() {
        if (Integer.parseInt(properties.getProperty("GPS")) == 0) {
            gpsDisabled();
        } else {
            gpsEnabled();
        }
    }

    public static void mobileNetworkBasedOnConfig() {
        if (Integer.parseInt(properties.getProperty("Mobile_network")) == 0) {
            mobileNetworkDisabled();
        } else {
            mobileNetworkEnabled();
        }
    }

    public static void airplaneModeBasedOnConfig() {
        if (Integer.parseInt(properties.getProperty("Airplane_mode")) == 0) {
            airplaneModeDisabled();
        } else {
            airplaneModeEnabled();
        }
    }


    public static List<String> runShellCmd(String cmd) {
        Process process = null;
        List<String> processResultList = new ArrayList<String>();
        try {
            process = Runtime.getRuntime().exec(cmd);
            BufferedReader input = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = input.readLine()) != null) {
                processResultList.add(line);
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return processResultList;
    }


}
