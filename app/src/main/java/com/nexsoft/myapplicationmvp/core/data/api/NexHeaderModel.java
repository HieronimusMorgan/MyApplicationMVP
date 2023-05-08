package com.nexsoft.myapplicationmvp.core.data.api;

public class NexHeaderModel {
    private String name;
    private String value;

    public NexHeaderModel(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
