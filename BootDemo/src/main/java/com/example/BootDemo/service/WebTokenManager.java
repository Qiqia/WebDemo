package com.example.BootDemo.service;

import com.example.BootDemo.dao.WebToken;
import com.example.BootDemoCore.util.CharUtil;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class WebTokenManager {
    private static Map<String, WebToken> tokenMap = new HashMap<>();
    private static Map<Integer, WebToken> idMap = new HashMap<>();

    public static Integer getUserId(String token) {

        WebToken userToken = tokenMap.get(token);
        if (userToken == null) {
            return null;
        }

        if (userToken.getExpireTime().isBefore(LocalDateTime.now())) {
            tokenMap.remove(token);
            idMap.remove(userToken.getUserId());
            return null;
        }

        return userToken.getUserId();
    }


    public static WebToken generateToken(Integer id) {
        WebToken userToken = null;

//        userToken = idMap.get(id);
//        if(userToken != null) {
//            tokenMap.remove(userToken.getToken());
//            idMap.remove(id);
//        }

        String token = CharUtil.getRandomString(32);
        while (tokenMap.containsKey(token)) {
            token = CharUtil.getRandomString(32);
        }

        LocalDateTime update = LocalDateTime.now();
        LocalDateTime expire = update.plusDays(1);

        userToken = new WebToken();
        userToken.setToken(token);
        userToken.setUpdateTime(update);
        userToken.setExpireTime(expire);
        userToken.setUserId(id);
        tokenMap.put(token, userToken);
        idMap.put(id, userToken);

        return userToken;
    }
}
