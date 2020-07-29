package example.controller;

import example.common.DataConstat;
import example.service.Person;
import example.service.impl.PersonService;
import example.service.SList;
import example.utils.OnMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by zsl on 2018/7/4.
 */
@Controller
@RequestMapping("/home")
@OnMethod(dnk = DataConstat.FSSF)
public class IndexController {
    @Autowired
    private PersonService personService;

    @Autowired
    private Person english;

    @Autowired
    private Person chinese;


    @Resource
    private List<SList> sListList;

    @RequestMapping("/index.do")
    @OnMethod(remark = "测试remark")
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception{
        personService.info();
        chinese.useAxe();
        english.useAxe();
        System.out.println("hello world!");

        System.out.println();
        System.out.println();
        for(SList sList:sListList){
            sList.say();
        }
        request.setAttribute("START_TIME", "start");

//            throw new Exception("dd");
//        String xadf = null;
//        System.out.println(xadf.toLowerCase());

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
