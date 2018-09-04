package com.example.BootDemo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by zsl on 2018/9/4.
 */
@RunWith(SpringRunner.class)
public class UserTest {
    private MockMvc mvc;

    @Before
    public void setUp() throws  Exception{
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }



    @Test
    public void testUser() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/springBoot/getUserByGet?userName=zsl").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("Hello zsl")));
    }

}
