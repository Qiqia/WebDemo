package setest;

/**
 * Created by zsl on 2018/8/27.
 */
public class OuterClass {



    public  OuterClass(String outerName,int outerAge){
        this.outerName = outerName;
        this.outerAge = outerAge;
    }

    public void soutOuterClass(){
        System.out.println("我是外部类");
        System.out.println("我的名字是:"+this.outerName);
        System.out.println("我的年龄是:"+this.outerAge);
        System.out.println("类的名称是:"+this.getClass().getName());

    }

    private String outerName;
    private int outerAge;
    private InnerClass innerClass;
    private StaticInnerClass staticInnerClass;

    class InnerClass{
        private String name;
        private int age;
        public InnerClass(String name ,int age){
            this.name = name;
            this.age = age;
        }

        public void soutIClass(){
            System.out.println("我是内部类");
            System.out.println("我的名字是:"+this.name);
            System.out.println("我的年龄是:"+this.age);
            System.out.println("类的名称是:"+InnerClass.this.getClass().getName());
        }
        public void changeOutAge(int age){
            OuterClass.this.outerAge = age;
            System.out.println("changerOutAge之后，外部类"+OuterClass.this.outerName+"的年龄是"+OuterClass.this.outerAge);
        }
    }

    static class StaticInnerClass{
        private String name;
        private int age;
        public StaticInnerClass(String name,int age){
            this.name = name;
            this.age = age;
        }
        public  void  soutSIClass(){
            System.out.println("我是静态嵌套类");
            System.out.println("我的名字是:"+this.name);
            System.out.println("我的年龄是:"+this.age);
            System.out.println("类的名称是:"+StaticInnerClass.this.getClass().getName());
        }

        public void changeOutAge(int age){
//            OuterClass.this.outerAge = age;
        }
    }
}
