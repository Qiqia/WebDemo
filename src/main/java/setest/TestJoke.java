package setest;

/**
 * Created by zsl on 2018/6/21.
 */
public class TestJoke implements Runnable{

    @Override
    public void run(){
        synchronized (this){
            System.out.println("heh");
            System.out.println("dfad");
            System.out.println("\"");
        }
    }



}
