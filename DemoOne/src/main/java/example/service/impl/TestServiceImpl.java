package example.service.impl;

import com.zsl.test.api.TestService;

/**
 * Created by zsl on 2018/7/26.
 */
public class TestServiceImpl implements TestService {
    @Override
    public String sayHello(String name) {
        System.out.println(name+"say:\"hello\"");
        return name+"say:\"hello\"";
    }
}
