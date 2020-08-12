package example.zsltest;

import org.apache.commons.lang3.StringUtils;

import java.util.Optional;

public class NPETest {
    class User{
        private String name;
        public User(String name){
            this.name = name ;
        }
        public String getUserName(){
            return this.name;
        }
        public Optional<String> getUserNameO(){
            return Optional.ofNullable(this.name);
        }

        public void setUserName(String name){
            this.name = name;
        }
    }
    public  User createUser(){
        System.out.println("creating User");
        return new User("zhangsan");
    }


    //涉及 of()  ofNullable()  orElse()  orElseGet()  orElseThrow() map()  flatMap() ifPresent()  filter()  的用法
    //详情 参考  https://www.cnblogs.com/rjzheng/p/9163246.html
    public static void main(String[] args) {
        NPETest test = new NPETest();
        User user = null;
        user = Optional.ofNullable(user).orElse(test.createUser());
        user = Optional.ofNullable(user).orElse(test.createUser());
        user = null;
        user = Optional.ofNullable(user).orElseGet(() ->test.createUser());
        user = Optional.ofNullable(user).orElseGet(() ->test.createUser());


        Optional.ofNullable(user).
                filter(u -> StringUtils.equals("zhangsan",u.getUserName())).
                ifPresent(u -> System.out.println("hello"));
        String fname = Optional.ofNullable(user).map(x -> x.getUserName()).get();
        System.out.println(fname+ "sdfa");



        user.setUserName(null);

        Optional.ofNullable(user).
                filter(u -> StringUtils.equals("zhangsan",u.getUserName())).
                ifPresent(u -> System.out.println("hello"));
        //这里有一个b 问题 user 非null 但是属性是null 这会有异常  map 或者flatMap都是
        String xname = Optional.ofNullable(user).flatMap(x -> x.getUserNameO()).get();



    }
}
