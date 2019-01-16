package com.chinaums.comtroller;

import com.alibaba.fastjson.JSONObject;
import com.chinaums.domain.WebToken;
import com.chinaums.domain.WebUser;
import com.chinaums.service.WebTokenManager;
import com.chinaums.util.JacksonUtil;
import com.chinaums.util.ResponseUtil;
import com.chinaums.util.bcrypt.BCryptPasswordEncoder;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import static com.chinaums.util.WebResponseCode.WEB_INVALID_ACCOUNT;

/**
 * Created by zsl on 2019/1/10.
 */
@RestController
@SpringBootApplication
@RequestMapping(value = "/liteweb")
public class UserController {
    private final static Logger _logger = LoggerFactory.getLogger(UserController.class);
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

    @RequestMapping(value = "/getUserByJson",method = RequestMethod.POST)
    String getUserByJson(@RequestBody String data){
        System.out.println("Json is " + data);
        return "Json is " + data;
    }

    @RequestMapping(value = "/loginDemo",method = RequestMethod.POST)
    String loginDemo(@RequestBody String data){
        _logger.info("开始loginDemo");
        WebUser loginWebUser = getUserFromRequestData(data);
        _logger.info("json is {}", loginWebUser.toString());
        return "登录用户的openid是：" + loginWebUser.getOpenId();
    }

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public Object login(@RequestBody String body){
        _logger.info("开始login");
        String userNameFront = JacksonUtil.parseString(body,"userName");
        String passwordFront = JacksonUtil.parseString(body,"password");

        if(StringUtils.isEmpty(userNameFront)|| StringUtils.isEmpty(passwordFront)){
            return ResponseUtil.badArgument();
        }

        List<WebUser> webList =getWebUser();
        Assert.state(webList.size()<2,"同一个用户名存在两个账户");
        if(webList.size() == 0){
            return ResponseUtil.badArgumentValue();
        }

        WebUser webUser = webList.get(0);

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(!encoder.matches(passwordFront,webUser.getPassword())){
            return ResponseUtil.fail(WEB_INVALID_ACCOUNT,"账户密码不匹配");
        }

        Integer webUserId = Integer.parseInt(webUser.getOpenId());

        WebToken webToken = WebTokenManager.generateToken(webUserId);

        return ResponseUtil.ok(webToken.getToken());
    }



    private WebUser getUserFromRequestData(String data){
        JSONObject jsonObject = JSONObject.parseObject(data);
        String userName = jsonObject.get("userName").toString();
        String password = jsonObject.get("password").toString();
        String openId = jsonObject.get("openId").toString();

        return new WebUser(userName,password,openId);
    }
    private List<WebUser> getWebUser(){
        return new ArrayList<WebUser>() {{
            add(new WebUser("zs","$2a$08$TTIofgnTC6c4jT06rT1cE./qaK/pz3wfPRTwJXprLaJ9WpbImwjBC","456897998"));
        }};
    }

    private static void  register(){
        String id =
    }
}
