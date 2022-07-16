package ru.mkb.GetClientBonus.spring.controller;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class DataResponse {
    private String data;

    private String data2;

    DataResponse(){;}

    public void setEmptyError() {
        this.data = "EMPTY REQUIRED FIELD";
        this.data2 = "ERROR";
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("{\"ErrorMsg\":\"").append(this.data).append("\",\"ErrorCode\":\"").append(this.data2).append("\"}");
        return str.toString();
    }
}
