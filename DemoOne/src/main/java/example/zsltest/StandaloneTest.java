package example.zsltest;

import org.apache.zookeeper.*;
import org.apache.zookeeper.data.Stat;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by zsl on 2018/7/25.
 * zookeeper简单测试
 */
public class StandaloneTest {
    private static final ZooKeeper zk;
    private static final  boolean isStandalone =false;
    static {
        try {
            if(isStandalone){
                zk = new ZooKeeper("127.0.0.1:2181", 30000, new TestWatcher());
            }else {
                zk = new ZooKeeper("127.0.0.1:2181,127.0.0.1:2182,127.0.0.1:2183",3000,new TestWatcher());
            }
            System.out.println("zk connect");
        }catch (Throwable e){
            throw new RuntimeException();
        }
    }

    public static void main(String[] args)throws KeeperException,InterruptedException{
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(new Runnable() {
            @Override
            public void run() {
                try{
                    Stat stat;
                    do{
                        stat =zk.exists("/test",true);
                        Thread.sleep(1000);
                    }while (stat!=null);
                }catch (Throwable e){
                    e.printStackTrace();
                }
            }
        });
    }

    private static class TestWatcher implements Watcher{

        @Override
        public void process(WatchedEvent watchedEvent) {
            StringBuilder sb = new StringBuilder();
            sb.append("path").append(":").append(watchedEvent.getPath()).append(" ")
                    .append("type").append(":").append(watchedEvent.getType()).append(" ")
                    .append("stat").append(":").append(watchedEvent.getState()).append(" ");
            System.out.println(sb.toString());
        }
    }
}
