package com.nexsoft.myapplicationmvp.core.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class ResponseModel {

    @JsonProperty("header")
    public HeaderModel header;

    @JsonProperty("payload")
    public PayloadModel payload;

    public HeaderModel getHeader() {
        return header;
    }

    public void setHeader(HeaderModel header) {
        this.header = header;
    }

    public PayloadModel getPayload() {
        return payload;
    }

    public void setPayload(PayloadModel payload) {
        this.payload = payload;
    }
}


