package setest;

import java.util.Random;

/**
 * Created by zsl on 2018/6/19.
 */
public class Ticket implements Runnable {
    private int total;
    private int count;
    private static long cost = 0;
    private long startTime;
    private boolean endStart = true;


    private Ticket() {
        total = 20;
        count = 0;
    }

    @Override
    public void run() {
        while (total > 0) {
            System.out.println("***********" + Thread.currentThread().getName() + "开始排队抢票" + "***********");
            synchronized (this) {
                if (count == 0) {
                    startTime = System.nanoTime();
//                    System.out.println("开始时间" + startTime);
                }

                if (total > 0) {
                    try {
                        System.out.println(Thread.currentThread().getName() + "抢到了票");
                        int time = new Random().nextInt(1000);
                        Thread.sleep(time);
                        cost += time;
                        System.out.println(Thread.currentThread().getName() + "买票花了" + time + "毫秒");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    count++;
                    total--;
                    System.out.println(Thread.currentThread().getName() + "\t当前票号：" + count);
                }

                if (count == 20 && endStart) {
                    long endTime = System.nanoTime();
                    System.out.println("最后一个抢到票的是：" + Thread.currentThread().getName());
//                    System.out.println("结束时间：" + endTime);
                    System.out.println("总耗时：" + (endTime - startTime) / 1000000);
                    System.out.println("总买票耗时：" + cost);
                    endStart = false;
                }
            }
        }

    }

    public static void main(String[] args) {
        Ticket ticket = new Ticket();
        for (int i = 1; i <= 5; i++) {
            new Thread(ticket, "售票点" + i).start();
        }
    }
}
