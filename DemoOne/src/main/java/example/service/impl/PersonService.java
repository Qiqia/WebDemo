package example.service.impl;

/**
 * Created by zsl on 2018/7/5.
 */
public class PersonService {
    private String name;



    public void setName(String name){
        this.name=name;
    }

    public void info(){
        System.out.println("此人名为"+name);
    }
}
