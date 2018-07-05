package example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zsl on 2018/7/4.
 */
@Controller
@RequestMapping("/home")
public class IndexController {

    @RequestMapping("/index.do")
    public String index(){
        System.out.println("hello world!");
        return "index";
    }
}
