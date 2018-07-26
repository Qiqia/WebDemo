package example.zsltest;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by zsl on 2018/7/26.
 */
public class DubboTest {
    public static void main(String[] args) throws IOException{
        new ClassPathXmlApplicationContext("spring/provider.xml");
        System.out.println("服役已经启动..");
        System.in.read();
    }
}
