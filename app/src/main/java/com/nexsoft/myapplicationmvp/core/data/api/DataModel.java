package com.nexsoft.myapplicationmvp.core.data.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Map;

public class DataModel {
    @JsonProperty("meta")
    public Map<String, Object> meta;

    @JsonProperty("content")
    public Object content;

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }
}
