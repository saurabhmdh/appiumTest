package com.android.automation.data;

import com.android.automation.interfaces.ItestSuite;
import com.android.automation.utils.Constants;

public class TestData {
    private Constants.Result resultIdentifer;
    private String diagnosis;

    private ItestSuite itestSuite;
    private int expectedOutput;
    private Constants.TestDecision decision;

    public TestData(String diagnosis, Constants.TestDecision decision, ItestSuite itestSuite, int expectedOutput) {
        this.diagnosis = diagnosis;
        this.itestSuite = itestSuite;
        this.expectedOutput = expectedOutput;
        this.decision = decision;
    }

    public void setResultIdentifer(Constants.Result resultIdentifer) {
        this.resultIdentifer = resultIdentifer;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public ItestSuite getItestSuite() {
        return itestSuite;
    }

    public int getExpectedOutput() {
        return expectedOutput;
    }

    public Constants.TestDecision getDecision() {
        return decision;
    }

    @Override
    public String toString() {
        return "TestData{" +
                "resultIdentifer=" + resultIdentifer +
                ", diagnosis='" + diagnosis + '\'' +
                ", itestSuite=" + itestSuite +
                ", expectedOutput=" + expectedOutput +
                ", decision=" + decision +
                '}';
    }
}
