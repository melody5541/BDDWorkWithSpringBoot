package io.cucumber.samples.dw.base;

/**
 * Created by stlv for developerworks article
 */
public class StandardJsonResponse<T> {
    private String errName = null;
    private String errMsg = "SUCCESS";
    private Integer errCode = Integer.valueOf(0);
    private T data;

    public String getErrName() {
        return errName;
    }

    public void setErrName(String errName) {
        this.errName = errName;
    }

    public String getErrMsg() {
        return errMsg;
    }

    public void setErrMsg(String errMsg) {
        this.errMsg = errMsg;
    }

    public Integer getErrCode() {
        return errCode;
    }

    public void setErrCode(Integer errCode) {
        this.errCode = errCode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
