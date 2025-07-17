package com.jmv.dto;

import lombok.ToString;

public class Msg {
    public Msg(String name) {
        this.name = name;
    }

    public Msg() {
    }

    private String name;
    private String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Msg{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
