package com.android.automation.data;

import com.android.automation.utils.Constants;

public class ResultData {
    private String type;
    private Constants.Result result;

    //TODO extra data
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Constants.Result getResult() {
        return result;
    }

    public void setResult(Constants.Result result) {
        this.result = result;
    }
}
