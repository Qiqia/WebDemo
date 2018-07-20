package setest;

import java.util.Random;

/**
 * Created by zsl on 2018/6/19.
 */
public class Ticket implements Runnable {
    private int total;
    private int count;

    public Ticket(){
        total=100;
        count=0;
    }

    @Override
    public void run() {
        while (total>0){
            System.out.println("***********"+"当前线程名："+Thread.currentThread().getName()  +"***********");
            synchronized (this){
                if (total>0){
                    try {
                        Thread.sleep(new Random().nextInt(1000));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    total--;
                    System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);
                }
            }
        }

    }

    public static void main(String[] args){
        Ticket ticket = new Ticket();
        for (int i=1 ;i<=5 ;i++){
            new Thread(ticket,"售票点"+i).start();
        }
    }
}
