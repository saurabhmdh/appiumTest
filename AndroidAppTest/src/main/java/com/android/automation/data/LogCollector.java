package com.android.automation.data;

import com.android.automation.utils.Constants;
import org.openqa.selenium.logging.LogEntry;

import java.util.ArrayList;
import java.util.List;

public class LogCollector {

    private static LogCollector mLogCollector = new LogCollector();
    private Object lock = new Object();
    private List<LogEntry> mLogs = new ArrayList<>();

    public static LogCollector getInstance() {
        return mLogCollector;
    }

    public List<LogEntry> getAllLog() {
        return mLogs;
    }

    public void parseLog(List<LogEntry> adbLogs) {
        synchronized (lock) {
            for (LogEntry log : adbLogs) {
                //System.out.println("Execute.." + log);
                if (log.getMessage().contains(Constants.RESULT_PATTERN)) {
                    mLogs.add(log);
                }
            }
        }
    }
}
