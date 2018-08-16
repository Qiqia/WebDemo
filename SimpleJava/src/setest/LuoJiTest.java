package setest;

/**
 * Created by zsl on 2018/8/16.
 */
public class LuoJiTest {
    public static void main(String[] args) {
        //testClass
       if(a()||b()){
           System.out.println("执行ab");
       }
       if (b()&&a()){
           System.out.println("执行ba");
       }
    }

    public static boolean a(){
        System.out.println("执行a");
        return true;
    }
    public static boolean b(){
        System.out.println("执行b");
        return false;
    }

    class TestClass{
        public TestClass(int x){
            this.g=x;
        }
        int g;
    }
}
