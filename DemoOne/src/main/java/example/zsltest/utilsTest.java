package example.zsltest;

import org.apache.commons.lang3.StringUtils;

/**
 * Created by zsl on 2019/5/23.
 */
public class utilsTest {
    public static void main(String[] args) {
        String sdfa = "http:fadf.com";
        int daf = StringUtils.indexOf(sdfa,"://");
        System.out.println(daf);
        sdfa=StringUtils.join("http://",sdfa);
        System.out.println(sdfa);
        System.out.println(StringUtils.equals("1",sdfa));

    }
}
