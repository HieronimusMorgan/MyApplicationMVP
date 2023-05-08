package com.nexsoft.myapplicationmvp.core.data.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class StatusModel {
    @JsonProperty("success")
    public boolean success;

    @JsonProperty("code")
    public String code;

    @JsonProperty("message")
    public String message;

    @JsonProperty("detail")
    public Map<String, Object> detail;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getDetail() {
        return detail;
    }

    public void setDetail(Map<String, Object> detail) {
        this.detail = detail;
    }
}
