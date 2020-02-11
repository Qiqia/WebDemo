package example.zsltest;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class RsaTest {
    public static void main(String[] args) throws Exception {
        String privateKey = "MIIEpAIBAAKCAQEAvzfO4of4rXecUmcYUIciOwU3mLYIcjtlz0D/Vbdbp+H80HAU" +
                "1eyRaJRykvoMdkHkiYk5x7q3L8dQHUTNniAhg9iBnUuYCy5jSYcJl0FAsyD5rCpz" +
                "jXK9Oyf5xcsDN8loswcXSn3ZdcZcv5VYrFJrm75Hk46YjPhF3vmz2CMUNaAzTuSj" +
                "lREjoVbxzzdnL5UkUAAUbwqdj3iZrthPpZtiyuECCAyzKIHE3fhxNoq/BtpmBROv" +
                "YpbEGtl6GxAZewd1Jhuym+QIOVUq/+Uz30kKWrJjdNlSchTJ0HHZY/VeX9sU3qZS" +
                "eCuKjaLINh4yZDaFlhaqGqUeykEulOj8rTro/QIDAQABAoIBAF1YqCVMDWjZQDW1" +
                "4FfHcD1xsY9aJctmFbBUYZF9nj/ZgWpbnMBF6UItXbVEXfsI9cDyfYN0MeMgIIr5" +
                "QItV0iaj9bpM4d9reMq3IkZ1c1k+2sNiQeCmR5xuSm91SI/eQb9L0eHqh9MHz9Uy" +
                "2gPdhGyWOijdbrk6phlQuqvjjAUU5Izib6Upg/EVWIf1v301TnC7uZGBtCKz3YPT" +
                "V9+UWG0ogy4Yz6rqx8nWp45uFCm4ZrOiwZsUS3XNVjYnzFPK2W0rm2ee1Ij7y/C5" +
                "rh99DWyqIjk3EWlaFp177yav9JMZ2vCIr5LCg7Ovz6OxqA9ZA/nKicXlvV8OUi7M" +
                "VtHhZoECgYEA4HqfqZugHhz3u1qz4DmQCsidOV/oSVMnRvDsUYCyQ/TF1CFFwUoo" +
                "VpD8bmcDh7IkcOz7CUo/1fJ71idcZowE0XQ/FSR0s/bFwyctMRfdbatxvYPKLOEz" +
                "Eqk+D6ssC6vDunKaGfoYpEDtX0tsfEwQ5sNSSfgF6Od3fUj+ZP4wJGECgYEA2hGM" +
                "BQ9dcMByXzrHZwbA0tdQdxt+n8TV5Pv+GFm8htK0ttSfCLEUcS801Aggow9hDCWZ" +
                "fbYorQXMwrkGaMCvz8KgC5W2LOagGx0UrirI4ZLr/6Nypsho69kb24+Nc62hYAUq" +
                "CtbDt/W7xtAysYiF3vFgr2nA3RusvYWzal47Ch0CgYEAtTcIsXkqt2SXMK42S6rs" +
                "d2ggVHLyKE9yg7h2bg1A28877NW3ZCSjj86XmeCbXu4WsPr+ZS+FfQe1pNo9o6Mh" +
                "OJ1pV34IoEd0uuhjeSBU5vXiaiV8DuL1wfjSWv/KHNnatidR8+qL/f1UIvvWZjlZ" +
                "45CGW6RX0P8a3Q8SHyF8Z8ECgYAmUYcFLJoCwg5W5YE8fVdMtUESbOZnNLNRNWaE" +
                "6N/T4RqYNexsHpG1AdKKn5L8lCs9cy3xhRzIqog8fz69EX7TRyPQZVJJuYzQtt93" +
                "a1U5LhQCK7ptzDGDn/bhMextM0l0EfQ9S1fA75E7ckI2KAM+FbQjnrWhJMfJ1cCd" +
                "JEnDkQKBgQDfkyCn2Y2VO5VnsNMUcbXT9YB45vQm+vg4e76rYiWuZUjMvDewsq6D" +
                "bU5+xL4ZauWJRqgoh9aoqTOadEP8jWpMUMzx0ii5QC7uKXeai5BYvDADXMwQuHwp" +
                "PdUsfTCinpTM+3qn90bUcSOLsvMJhkA1YnhU2ET09CwntpKPjaYvgw==";

        String privateKeyPKCS8 = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQC/N87ih/itd5xS" +
                "ZxhQhyI7BTeYtghyO2XPQP9Vt1un4fzQcBTV7JFolHKS+gx2QeSJiTnHurcvx1Ad" +
                "RM2eICGD2IGdS5gLLmNJhwmXQUCzIPmsKnONcr07J/nFywM3yWizBxdKfdl1xly/" +
                "lVisUmubvkeTjpiM+EXe+bPYIxQ1oDNO5KOVESOhVvHPN2cvlSRQABRvCp2PeJmu" +
                "2E+lm2LK4QIIDLMogcTd+HE2ir8G2mYFE69ilsQa2XobEBl7B3UmG7Kb5Ag5VSr/" +
                "5TPfSQpasmN02VJyFMnQcdlj9V5f2xTeplJ4K4qNosg2HjJkNoWWFqoapR7KQS6U" +
                "6PytOuj9AgMBAAECggEAXVioJUwNaNlANbXgV8dwPXGxj1oly2YVsFRhkX2eP9mB" +
                "alucwEXpQi1dtURd+wj1wPJ9g3Qx4yAgivlAi1XSJqP1ukzh32t4yrciRnVzWT7a" +
                "w2JB4KZHnG5Kb3VIj95Bv0vR4eqH0wfP1TLaA92EbJY6KN1uuTqmGVC6q+OMBRTk" +
                "jOJvpSmD8RVYh/W/fTVOcLu5kYG0IrPdg9NX35RYbSiDLhjPqurHydanjm4UKbhm" +
                "s6LBmxRLdc1WNifMU8rZbSubZ57UiPvL8LmuH30NbKoiOTcRaVoWnXvvJq/0kxna" +
                "8IivksKDs6/Po7GoD1kD+cqJxeW9Xw5SLsxW0eFmgQKBgQDgep+pm6AeHPe7WrPg" +
                "OZAKyJ05X+hJUydG8OxRgLJD9MXUIUXBSihWkPxuZwOHsiRw7PsJSj/V8nvWJ1xm" +
                "jATRdD8VJHSz9sXDJy0xF91tq3G9g8os4TMSqT4PqywLq8O6cpoZ+hikQO1fS2x8" +
                "TBDmw1JJ+AXo53d9SP5k/jAkYQKBgQDaEYwFD11wwHJfOsdnBsDS11B3G36fxNXk" +
                "+/4YWbyG0rS21J8IsRRxLzTUCCCjD2EMJZl9tiitBczCuQZowK/PwqALlbYs5qAb" +
                "HRSuKsjhkuv/o3KmyGjr2Rvbj41zraFgBSoK1sO39bvG0DKxiIXe8WCvacDdG6y9" +
                "hbNqXjsKHQKBgQC1NwixeSq3ZJcwrjZLqux3aCBUcvIoT3KDuHZuDUDbzzvs1bdk" +
                "JKOPzpeZ4Jte7haw+v5lL4V9B7Wk2j2joyE4nWlXfgigR3S66GN5IFTm9eJqJXwO" +
                "4vXB+NJa/8oc2dq2J1Hz6ov9/VQi+9ZmOVnjkIZbpFfQ/xrdDxIfIXxnwQKBgCZR" +
                "hwUsmgLCDlblgTx9V0y1QRJs5mc0s1E1ZoTo39PhGpg17GwekbUB0oqfkvyUKz1z" +
                "LfGFHMiqiDx/Pr0RftNHI9BlUkm5jNC233drVTkuFAIrum3MMYOf9uEx7G0zSXQR" +
                "9D1LV8DvkTtyQjYoAz4VtCOetaEkx8nVwJ0kScORAoGBAN+TIKfZjZU7lWew0xRx" +
                "tdP1gHjm9Cb6+Dh7vqtiJa5lSMy8N7CyroNtTn7Evhlq5YlGqCiH1qipM5p0Q/yN" +
                "akxQzPHSKLlALu4pd5qLkFi8MANczBC4fCk91Sx9MKKelMz7eqf3RtRxI4uy8wmG" +
                "QDVieFTYRPT0LCe2ko+Npi+D";

        String publicKey = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAvzfO4of4rXecUmcYUIci" +
                "OwU3mLYIcjtlz0D/Vbdbp+H80HAU1eyRaJRykvoMdkHkiYk5x7q3L8dQHUTNniAh" +
                "g9iBnUuYCy5jSYcJl0FAsyD5rCpzjXK9Oyf5xcsDN8loswcXSn3ZdcZcv5VYrFJr" +
                "m75Hk46YjPhF3vmz2CMUNaAzTuSjlREjoVbxzzdnL5UkUAAUbwqdj3iZrthPpZti" +
                "yuECCAyzKIHE3fhxNoq/BtpmBROvYpbEGtl6GxAZewd1Jhuym+QIOVUq/+Uz30kK" +
                "WrJjdNlSchTJ0HHZY/VeX9sU3qZSeCuKjaLINh4yZDaFlhaqGqUeykEulOj8rTro" +
                "/QIDAQAB";

//        PrivateKey privateKeyA = getPrivateKey(privateKey);
        PrivateKey privateKeyPKCS8A = getPrivateKey(privateKeyPKCS8);
        PublicKey publicKeyA = getPublicKey(publicKey);

        byte [] salt = {'s','x'};
        System.out.println(new String(salt));

        byte [] content = encrypt(salt,publicKeyA);

//        System.out.println(new String(content));

//        byte [] afterA = decrypt(content,privateKeyA);
        byte [] afterPKCS8 = decrypt(content,privateKeyPKCS8A);
//        System.out.println(afterA.toString());
        System.out.println(new String(afterPKCS8));



    }


    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes;
//        String key ="MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAJYyYuFF/z9Rd69JoJCI7YfI5AtroLYL7J1sWdHcO3BGPKbaAlVMsP7QML7F/XvEULDtKK+D8nOL6vmDkfHsL32b3WVOLNwCi8Mnnr5TbBVb3foKONP+tpuPVOnEb7NVqKvtl9M5irGdVW1LqFEMeDshEDYMf1g6MaO4uM3Ltg5LAgMBAAECgYBtjxF7m7CFwmpYTY+2/nqtiod2ISsYv/f4GPonz8r3qfRCDVKYYBnXtYtpDUlKx7fIZyY/aTMov85F9Yg2/P7iMeGj1yOnVbnY2IePER++VXmjANa2elvF0feW9oIhBgJATPK38mfmhTo+pk9eIzlI7FzXNjLTZnjA/BWir1aE0QJBAOhtLotDGs6Y0JXXEOzuYMLdV7NXolq1lyQ2xrCEsX+CO+AAFioKwcawKmMAORdBryMCNDjQSWUElveyCMsmLnMCQQClbii3Vo6NbnsjZLTuajdBWxx0SpSR9hpGIMAslUI2894yC3JMKFwyr0loLADJ4J+ofgxvY18LhMIkdjXNSpLJAkEAlkLnwU6ryP7Qct6saZCe67vvU9mG87/MK7Rh9YKDwhxvGxzTN3Dm383KSWC+iAOF90sYedZmbLFv7EikGLnhcwJAEAVyJgdY+POJM21OZISe41J6l/ydFOG7u6zyT58I8Z9+lmQrZprGCxaUymTwkpyRedTzSVpbWxc5YiSco0wkmQJABxqvas1lDjOhB2x3a3sle/aqMV5HEQSBFHewCOR7MppJLzSwAKQukOHGw5FtYBlJ7QTp8fj1Ji1HfrQpWagjtA==";
//        String key ="MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQDJ70Sp8SYU7XryT+W2ayeOwToadbzOqgt+WhzlELx+G95dZTUrwr/rgPujpjHGVjn0AoGGJj2SrbunT0ULRAC4ztPlhLjWxxfSdWTvtvLoOhJL/3eFWlpcZhfQ2FdrIi+WKyZKiOCLgZsXTn/GV82vl1ibZh6Jy7XoaFC5TWvHvY0FGuULgQcArtzfJYcVtNtxTrQheQsiJ5/844uIYqg8988OrIDSHJQMeWNToeIWC5WcVeauGcQS3UBgvXqaK/aL4bkzy95YISjs/ZmYrrdbWj4HcK6Xb8o0s52m6gZWpfwfh4Ao537bh5jTfsz+gG8b+nItwSEjL6+863y879kVAgMBAAECggEBAIL2KRrp6V+zMIRL6temoO4FRPB6ISwKvg+A07J/ay+CVXFOvPAXiq5qZUiZ9TgDHeyxX10oGdCx2bzFPSr0PF+ey2/T5qhsUHfOaNrKVLjlSI5/LP2QPoAkOhfY5sD1V9VVQK0gHjh7oqC36UgyE5RoXC/UR8PoGJ6UYJ38pwTPM7twVaDtgyx9WC04HojLlxNQUexjktINGt0rDDeDJlyEA8PQSSaxpoOYhGWWN4MNVdNdgOGitxIDVw7H+UW1ad+wCuvXlLTE4uVG3UU8JH8hu5lAJE9Fme/fxWvE0iNON+/xxVpyj5tlKJRbWBHsV8bylPYjoWPiWCRwY2NnP3UCgYEA6zm9VwF3muUSJNhTjZ5zCfIPZpW+pup72KwfzEaymZIU7A0jNU1LhlUzCC++n6eHD21oYQcdzFqY0diRUutKxueb7DLc0GmzXTfK26WSgwC65Q5VdrIh4Bairy0ecTu0dWhwY1d4OYC5biXIkDkqZjLxmhH6UUrd4x1cUxWtvrsCgYEA28TZGbB3ZDrI3sahVVfBaZ3+Kuoq2PvOza4luof2jW6J3RMD2nQGgFidk55C75gmeV+8sPg4ZKlMJBLWEQOaPhKLTcKfLDai5b6k1ZiDoPwsOsX4w0en+guyiqz6Zo1KOh5PWsImBgvOxnN09Ndg+X1I+o5qtBHB6D2SefkDEm8CgYEAgzbMRdKNs5wAyQjbYu52YZ/js2fo2BeJSk6J1lvBmSUCAsM5VqxtatvwAasQfOLo1lRDm4xqtOn8wWI7frO+HMJqGhItVxz/bwqGYIw19Fnd55RdXD714pj92xYiGywg+DVwLBpI+Fq0FZuCC+G3oxbb6wQITHyk1eI09Cvtpa0CgYBAIgjM419kA3ec81AfbJWHsdB7S4ynd4xZH2npLkY37bsTpbnpJRTEnZeWfYfBDaCkqNiSuE0UqwcKO+j2XBvF43l9fr8eku8kpmbJ4lD/SLfLivxWWHHfmUxIBcSo6rBvl2rG7INWHloANa86yCOHixUh8S+YTtpMYLN/HrjTxwKBgQDB4N1bCjCJBQaJz2hlVQOqMX3qARSjmMa5WMgDCBEBjh7B+95U4TSKAaTPNYw0c4pug9hipN8CzXBa579ky0iwP++vZHOjuMUaHumVMUmk0Ydilb5Hv3mmg38MveDM7W1Fqja0cGXsjDmLtvaAPt/qaqZnBOeXQj6U7WMEdQ/BfQ==";
        keyBytes = Base64.decodeBase64(key);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }


    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes;
        keyBytes = Base64.decodeBase64(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }


    public static String encrypt(String content, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            byte[] output = cipher.doFinal(content.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(output);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }


    //私钥解密
    public static String decrypt(String content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            byte[] b = cipher.doFinal(content.getBytes());
            BASE64Encoder encoder = new BASE64Encoder();
            return encoder.encode(b);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    //私钥解密
    public static byte[] decrypt(byte[] content, PrivateKey privateKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
            cipher.init(Cipher.DECRYPT_MODE, privateKey);
            return cipher.doFinal(content);
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }



    //公钥加密
    public static byte[] encrypt(byte[] content, PublicKey publicKey) {
        try {
            Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");//java默认"RSA"="RSA/ECB/PKCS1Padding"
            cipher.init(Cipher.ENCRYPT_MODE, publicKey);
            return cipher.doFinal(content);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
