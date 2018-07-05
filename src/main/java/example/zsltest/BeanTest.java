package example.zsltest;

import example.service.Person;
import example.service.impl.Chinese;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zsl on 2018/7/5.
 */
public class BeanTest {
    public static void main(String[] args){
        ApplicationContext act= new ClassPathXmlApplicationContext("applicationContext.xml");
        Person person = act.getBean("chinese", Chinese.class);

        person.useAxe();

    }
}
