package example.service.impl;

import example.service.SList;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(1)
public class Xiao implements SList {
    @Override
    public void say(){
        System.out.println("小");
    }
}
