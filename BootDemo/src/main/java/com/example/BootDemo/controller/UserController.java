package com.example.BootDemo.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.BootDemo.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zsl on 2018/9/4.
 */
//@RestController注解能够使项目支持Rest
@RestController
@SpringBootApplication
@RequestMapping(value = "/springBoot")
public class UserController {
    private final static Logger _logger =LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/getUserByGet",method = RequestMethod.GET)
    String getUserByGet(@RequestParam(value = "userName")String userName){
        System.out.println("Hello " + userName);
        return "Hello "+userName;
    }

    @RequestMapping(value = "/getUserByPost",method = RequestMethod.POST)
    String getUserByPost(@RequestParam(value = "userName")String userName){
        System.out.println("Hello " + userName);
        return "Hello "+userName;
    }

    @RequestMapping(value = "getUserByJson",method = RequestMethod.POST)
    String getUserByJson(@RequestBody String data){
        System.out.println("Json is " + data);
        return "Json is " + data;
    }
    @RequestMapping(value = "loginDemo",method = RequestMethod.POST)
    String loginDemo(@RequestBody String data){
        _logger.info("开始loninDemo");

        User loginUser = getUserFromRequestData(data);
        _logger.info("json is {}",loginUser.toString());
        return "登录用户的openid是：" + loginUser.getOpenId();
    }


    public User getUserFromRequestData(String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        String userName = jsonObject.get("userName").toString();
        String password = jsonObject.get("password").toString();
        String openId = jsonObject.get("openId").toString();

        return new User(userName,password,openId);
    }
//this is a boot in linux
}
