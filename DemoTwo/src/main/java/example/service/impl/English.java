package example.service.impl;

import example.service.Axe;
import example.service.Person;

/**
 * Created by zsl on 2018/7/17.
 */
public class English implements Person{
    private Axe axe;

    public void setAxe(Axe axe){
        this.axe =axe;
    }
    public void useAxe(){
        System.out.println("I like English very much");
        System.out.println(axe.chop());
    }
}
