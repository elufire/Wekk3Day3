package com.example.wekk3day3;

import com.example.wekk3day3.user.Result;

public class ResultEvent {
    private Result result;

    public ResultEvent(Result result) {
        this.result = result;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }
}
