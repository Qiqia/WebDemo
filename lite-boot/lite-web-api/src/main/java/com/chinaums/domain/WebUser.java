package com.chinaums.domain;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by zsl on 2019/1/10.
 */
@AllArgsConstructor
public class WebUser {
    @Getter
    @Setter
    private String userName;
    @Getter
    @Setter
    private String password;
    @Getter
    @Setter
    private String openId;

    public String toString(){
        return JSON.toJSONString(this);
    }
}
