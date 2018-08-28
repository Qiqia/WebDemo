package setest;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        System.out.println("\\\\\\"+"lin");


        OuterClass outerClass = new OuterClass("老大",100);
        outerClass.soutOuterClass();

        OuterClass.InnerClass innerClass = outerClass.new InnerClass("老二",90);
        innerClass.soutIClass();

        innerClass.changeOutAge(80);
        outerClass.soutOuterClass();

        OuterClass.StaticInnerClass staticInnerClass = new OuterClass.StaticInnerClass("老三",70);
        staticInnerClass.soutSIClass();

    }
}
