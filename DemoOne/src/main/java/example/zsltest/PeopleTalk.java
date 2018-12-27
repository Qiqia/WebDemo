package example.zsltest;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zsl on 2018/12/27.
 */
public class PeopleTalk implements ITalk{
    @Getter
    @Setter
    public String username;
    @Getter
    @Setter
    public String age;
    public PeopleTalk(String username,String age){
        this.username = username;
        this.age = age;
    }
    public void talk(String msg){
        System.out.println(msg + "!你好，我是" + username + ",我的年龄是" + age);
    }
}
