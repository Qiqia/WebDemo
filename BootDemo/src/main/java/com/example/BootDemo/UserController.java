package com.example.BootDemo;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

/**
 * Created by zsl on 2018/9/4.
 */
//@RestController注解能够使项目支持Rest
@RestController
@SpringBootApplication
@RequestMapping(value = "/springboot")
public class UserController {
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
}
