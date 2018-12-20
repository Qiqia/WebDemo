package com.example.BootDemo.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/**
 * Created by zsl on 2018/12/20.
 */
@AllArgsConstructor
public class User {
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String openId;
}
