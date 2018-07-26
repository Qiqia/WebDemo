package example.zsltest;

import com.zsl.test.api.TestService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by zsl on 2018/7/26.
 */
public class DubboTest {
    public static void main(String[] args) throws IOException{
        ClassPathXmlApplicationContext context=new ClassPathXmlApplicationContext("/spring/consumer.xml");

        System.out.println("输入任何字符可以调用远程rpc服务");
        System.in.read();

        TestService testService =context.getBean(TestService.class);

        String sayHello = testService.sayHello("qiqia");
        System.out.println(sayHello);
    }
}

