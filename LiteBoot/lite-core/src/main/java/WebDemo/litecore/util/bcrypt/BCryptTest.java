package WebDemo.litecore.util.bcrypt;

import org.apache.commons.codec.digest.DigestUtils;

import java.security.MessageDigest;

/**
 * Created by zsl on 2019/1/7.
 */
public class BCryptTest {
    public static void main(String[] args) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
        System.out.println(encoder.encode("123456"));

        MessageDigest messageDigest= DigestUtils.getDigest("MD5");


        System.out.println(DigestUtils.md2Hex("zs".getBytes()));
        System.out.println(DigestUtils.md2Hex("zs"));





        System.out.println(messageDigest.getAlgorithm());



//        System.out.println(encoder.matches("4545","$2a$10$YzHR3W5S6UI3qvN6D61uduIKlZWd0iO9HpfvoIEr20dBgnSIDOmpK"));
//
//        String how = "$2a$10$YzHR3W5S6UI3qvN6D61uduIKlZWd0iO9HpfvoIEr20dBgnSIDOmpK";
//        System.out.println(how.length());

    }
}
