package com.android.automation.data;

public class InputData {
    String testCase;
    String execute;
    String expectedResult;

    public InputData(String testCase, String execute, String expectedResult) {
        this.testCase = testCase;
        this.execute = execute;
        this.expectedResult = expectedResult;
    }

    public String getTestCase() {
        return testCase;
    }

    public String isExecutable() {
        return execute;
    }

    public String getExpectedResult() {
        return expectedResult;
    }

    @Override
    public String toString() {
        return "InputData{" +
                "testCase='" + testCase + '\'' +
                ", execute='" + execute + '\'' +
                ", expectedResult='" + expectedResult + '\'' +
                '}';
    }
}
