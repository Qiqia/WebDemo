package example.zsltest;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by zsl on 2019/1/17.
 * uuid去“-”号的方式
 */
public class UUIDtest {
    public static void main(String[] args) {
        UUID uuidx = UUID.randomUUID();
        System.out.println(uuidx.toString().replace("-",""));
        System.out.println(uuidx.toString().replaceAll("-",""));
        System.out.println(Long.toHexString(uuidx.getMostSignificantBits())+Long.toHexString(uuidx.getLeastSignificantBits()));

        final int SIZE =10000;
        List<UUID> first = new ArrayList<UUID>(){{
            for (int i =0 ;i<SIZE; i++){
                add(UUID.randomUUID());
            }
        }};
        long l1=System.currentTimeMillis();
        first.forEach(key -> directlyToString(key));
        long l2=System.currentTimeMillis();
        first.forEach(key -> arrayCopyToString(key));
        long l3=System.currentTimeMillis();
        first.forEach(key -> subStringToString(key));
        long l4=System.currentTimeMillis();
        first.forEach(key -> forToString(key));
        long l5=System.currentTimeMillis();
        first.forEach(key -> replaceToString(key));
        long l6=System.currentTimeMillis();
        System.out.println(l2-l1);
        System.out.println(l3-l2);
        System.out.println(l4-l3);
        System.out.println(l5-l4);
        System.out.println(l6-l5);
    }

    /**
     * toHexString方法
     * @param uuid
     * @return
     */
    private static String directlyToString(UUID uuid) {
        return Long.toHexString(uuid.getMostSignificantBits()) + Long.toHexString(uuid.getLeastSignificantBits());
    }

    /**
     * arrayCopy方法
     * @param uuid
     * @return
     */
    private static String arrayCopyToString(UUID uuid) {
        char[] dest = new char[32];
        char[] src = uuid.toString().toCharArray();
        System.arraycopy(src, 0, dest, 0, 8);
        System.arraycopy(src, 9, dest, 8, 4);
        System.arraycopy(src, 14, dest, 12, 4);
        System.arraycopy(src, 19, dest, 16, 4);
        System.arraycopy(src, 24, dest, 20, 12);
        return new String(dest);
    }

    /**
     * subString方法
     * @param uuid
     * @return
     */
    private static String subStringToString(UUID uuid) {
        String src = uuid.toString();
        return src.substring(0, 8) + src.substring(9, 13) + src.substring(14, 18) + src.substring(19, 23) + src.substring(24, 36);
    }

    /**
     * forToString方法
     * @param uuid
     * @return
     */
    private static String forToString(UUID uuid) {
        char[] src = uuid.toString().toCharArray();
        char[] chars = new char[32];
        for (int i = 0, j = 0; i < src.length; i++) {
            char c = src[i];
            if ('-' != c) {
                chars[j++] = c;
            }
        }
        return new String(chars);
    }

    /**
     * 正则方式
     * @param uuid
     * @return
     */
    private static String replaceToString(UUID uuid) {
        return uuid.toString().replaceAll("-", "");
    }
}
