package com.android.automation.data;

import java.util.ArrayList;
import java.util.List;

public class AutoTestData {
    private static AutoTestData instance = new AutoTestData();
    private List<TData> testcases = new ArrayList<>();

    private AutoTestData() {
    }

    public static AutoTestData getInstance() {
        return instance;
    }

    public void addTestEntry(TData data) {
        testcases.add(data);
    }

    public List<TData> getALLAutoTestCases() {
        return testcases;
    }

    public TData find(String key) {
        for (TData data : testcases) {
            if (data.getTestID().equals(key)) {
                return data;
            }
        }
        return null;
    }

    public static class TData {
        String testID;
        String expected;

        public TData(String testID, String expected) {
            this.testID = testID;
            this.expected = expected;
        }

        public String getTestID() {
            return testID;
        }

        public String getExpected() {
            return expected;
        }
    }
}
