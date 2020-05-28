package com.ctra.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class User {
    private int id;
    private String name;
    private String password;
}
