package setest;

/**
 * Created by zsl on 2018/6/12.
 */
public class ThreadTest implements Runnable {
    private  Thread t;
    private  String threadName;
    ThreadTest(String name){
        this.threadName = name;
        System.out.println("Creating"+this.threadName);
    }
    @Override
    public void run() {
        System.out.println("Running"+threadName);
        try {
            for(int i =4 ;i>0;i--){
                System.out.println("Thread:"+threadName+","+i);
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " +  threadName + " interrupted.");
        }
        System.out.println("Thread " +  threadName + " exiting.");
    }

    public void start(){
        System.out.println("Starting " +  threadName );
        if (t == null) {
            t = new Thread (this, threadName);
            t.start ();
        }
    }

    public static void main(String[] args ){
        ThreadTest R1 = new ThreadTest("Thread-1");
        R1.start();
        ThreadTest R2 = new ThreadTest("Thread-2");
        R2.start();
    }
}
