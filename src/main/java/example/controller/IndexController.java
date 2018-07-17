package example.controller;

import example.service.Person;
import example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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

    @RequestMapping("/index.do")
    public String index(){
        personService.info();
        System.out.println("hello world!");
        english.useAxe();
        return "index";
    }
}
