package example.zsltest;

import java.util.UUID;

/**
 * Created by zsl on 2019/1/17.
 */
public class UUIDtest {
    public static void main(String[] args) {
        String uuid1 = UUID.randomUUID().toString().replace("-","");
        String uuid2 = UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuid1);
        System.out.println(uuid2);
        long start = System.currentTimeMillis();
        for (int i =0;i<100000;i++){
            System.out.println(UUID.randomUUID().toString().replaceAll("-",""));
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
