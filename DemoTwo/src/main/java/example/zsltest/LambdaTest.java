package example.zsltest;

import example.pojo.Person;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by zsl on 2018/9/13.
 */
public class LambdaTest {
    public static void main(String[] args) {
        List<Person> guiltyPersons = Arrays.asList(
                new Person("Yixing","Zhao",25),
                new Person("Yanggui","Li",30),
                new Person("Chao","Ma",29)
        );

        guiltyPersons.stream()
                .filter(person -> person.getAge()>26)
                .sorted((p1,p2) ->p1.getAge()-p2.getAge())
                .forEach(p-> System.out.println(p.getFirstName()));


        guiltyPersons.stream()
                .filter(p-> p.getLastName().startsWith("Z"))
                .forEach(p-> System.out.println(p.getFirstName()));


        guiltyPersons.stream()
                .filter(p->p.getLastName().startsWith("Z"))
                .forEach(System.out::println);

        checkAndExecute(guiltyPersons,
                p-> p.getLastName().startsWith("Z"),
                p-> System.out.println(p.getFirstName()));

        example.service.Person person =()-> System.out.println("我在用lambda斧头");
        person.useAxe();
    }


    public static void checkAndExecute(List<Person> personList,
                                       Predicate<Person> predicate,
                                       Consumer<Person> consumer
                                       ){

        personList.forEach(p->{if(predicate.test(p)) consumer.accept(p);});
    }
}
