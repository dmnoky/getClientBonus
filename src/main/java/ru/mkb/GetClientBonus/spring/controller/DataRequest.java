package ru.mkb.GetClientBonus.spring.controller;

import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.NonNull;

@Getter @Setter
public class DataRequest {
    @NonNull
    private String client;
}
