package com.example.gankiomy.net;

/**
 * Created by guodazhao on 2018/2/8 0008.
 */

public class BaseResult<T> {
    private boolean error;
    private T results;
    private String msg;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public T getResults() {
        return results;
    }

    public void setResult(T results) {
        this.results = results;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
