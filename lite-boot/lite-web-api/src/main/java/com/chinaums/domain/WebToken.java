package com.chinaums.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Created by zsl on 2019/1/10.
 */

public class WebToken {
    @Getter
    @Setter
    private String userId;
    @Getter
    @Setter
    private String token;
    @Getter
    @Setter
    private LocalDateTime expireTime;
    @Getter
    @Setter
    private LocalDateTime updateTime;
}
