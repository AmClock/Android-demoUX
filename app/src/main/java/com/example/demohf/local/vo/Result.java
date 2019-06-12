package com.example.demohf.local.vo;

/**
 * @file Result.java
 * @author park
 */
public class Result {
    private Boolean result;

    public Result(String result){
        this.result = Boolean.valueOf(result);
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Boolean getResult() {
        return result;
    }
}
