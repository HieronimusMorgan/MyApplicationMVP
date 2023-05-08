package com.nexsoft.myapplicationmvp.core.data.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(
        ignoreUnknown = true
)
public class NexBaseDataModel<T> {

    @JsonProperty("nexsoft")
    public ResponseModel nexsoft;

    public ResponseModel getNexsoft() {
        return nexsoft;
    }

    public void setNexsoft(ResponseModel nexsoft) {
        this.nexsoft = nexsoft;
    }

}
