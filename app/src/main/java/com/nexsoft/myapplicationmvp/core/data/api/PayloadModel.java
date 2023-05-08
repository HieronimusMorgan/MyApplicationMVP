package com.nexsoft.myapplicationmvp.core.data.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;


public class PayloadModel {
    @JsonProperty("status")
    public StatusModel status;

    @JsonProperty("data")
    public DataModel data;

    @JsonProperty("other")
    public Map<String, Object> other;

    public StatusModel getStatus() {
        return status;
    }

    public void setStatus(StatusModel status) {
        this.status = status;
    }

    public DataModel getData() {
        return data;
    }

    public void setData(DataModel data) {
        this.data = data;
    }

    public Map<String, Object> getOther() {
        return other;
    }

    public void setOther(Map<String, Object> other) {
        this.other = other;
    }
}
