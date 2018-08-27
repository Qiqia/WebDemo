package setest;

/**
 * Created by zsl on 2018/8/27.
 */
public class PrivClass {

//    public PrivClass(TClass tClass){
//        this.tClass = tClass;
//    }


    private TClass tClass;

    class TClass{
        private String name;
        private int age;
        public TClass(String name ,int age){
            this.name = name;
            this.age = age;
        }

        public void soutTclass(){
            System.out.println("名字是"+this.name);
            System.out.println("年龄是"+this.age);
            System.out.println(TClass.this.getClass().getName());
        }
    }
}
