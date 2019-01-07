package com.example.BootDemoCore.util.bcrypt;

/**
 * Created by zsl on 2019/1/7.
 */
public class BCryptTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8,16);
        System.out.println(encoder.encode("19910417zhu"));


        System.out.println(encoder.matches("4545","$2a$10$YzHR3W5S6UI3qvN6D61uduIKlZWd0iO9HpfvoIEr20dBgnSIDOmpK"));
    }
}
