package com.example.demo.model;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class User {
    long account;
    @NotBlank(message = "Поле имени не может быть пустым")
    String name;
    double value;
}
