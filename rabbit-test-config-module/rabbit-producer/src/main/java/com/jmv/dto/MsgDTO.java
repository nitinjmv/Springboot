package com.jmv.dto;

import lombok.Data;

import java.io.Serializable;

public class MsgDTO implements Serializable {

    private boolean status;
    private String id;
    private String name;

    public MsgDTO() {}
    public MsgDTO(String id, String name, boolean status) {
        this.id = id;
        this.status = status;
        this.name = name;
    }
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "MsgDTO{id='" + id + "', name='" + name + "'}";
    }
}