package example.controller;

import example.service.Person;
import example.service.impl.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zsl on 2018/7/4.
 */
@Controller
@RequestMapping("/home")
public class IndexController {
    @Autowired
    private PersonService personService;

    @Autowired
    private Person english;

    @Autowired
    private Person chinese;

    @RequestMapping("/index.do")
    public String index(){
        personService.info();
        chinese.useAxe();
        english.useAxe();
        System.out.println("hello world!");
        return "index";
    }
}
