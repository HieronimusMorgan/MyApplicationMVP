package com.nexsoft.myapplicationmvp.core.data.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class HeaderModel {
    @JsonProperty("request_id")
    public String requestId;

    @JsonProperty("version")
    public String version;

    @JsonProperty("timestamp")
    public String timestamp;

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
