package example.service.impl;

import example.service.SList;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(2)
public class Da implements SList {
    @Override
    public void say() {
        System.out.println("大");
    }
}
