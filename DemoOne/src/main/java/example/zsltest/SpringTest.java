package example.zsltest;

import example.service.impl.PersonService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zsl on 2018/7/5.
 */
public class SpringTest {
    public static void main(String[] args){

        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
        System.out.println(ctx);
        PersonService personService =ctx.getBean("personService",PersonService.class);
        personService.info();

    }
}
