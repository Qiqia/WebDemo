package example.controller;

import example.service.Person;
import example.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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


    @RequestMapping("/cleanmodel.do")
    public View cleanmodel(Model model){
        model.addAttribute("aaa","aaaa");
        model.asMap().clear();
        System.out.println("dafa"+model.containsAttribute("aaa"));
        return new RedirectView("http://www.baidu.com",false,false,true);
    }
}
