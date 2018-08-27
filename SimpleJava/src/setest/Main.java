package setest;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        System.out.println("\\\\\\"+"lin");

        PrivClass privClass = new PrivClass();

        PrivClass.TClass tClass = privClass.new TClass("xiaoming",18);
        tClass.soutTclass();


    }
}
