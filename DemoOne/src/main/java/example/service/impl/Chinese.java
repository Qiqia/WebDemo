package example.service.impl;

import example.service.Axe;
import example.service.Person;

/**
 * Created by zsl on 2018/7/5.
 */
public class Chinese implements Person {
    private Axe axe;

    public void setAxe(Axe axe){
        this.axe =axe;
    }
    public void useAxe(){
        System.out.println(axe.chop());
    }
}
