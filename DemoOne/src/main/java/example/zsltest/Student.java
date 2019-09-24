package example.zsltest;

import lombok.Getter;
import lombok.Setter;

public class Student {
    @Getter
    @Setter
    public String name;
    @Getter
    @Setter
    public String age;
    Student(String name,String age){
        this.name = name;
        this.age = age;
    }
}
