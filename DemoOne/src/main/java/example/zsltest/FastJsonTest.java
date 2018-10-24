package example.zsltest;

import com.alibaba.fastjson.JSON;

/**
 * Created by zsl on 2018/10/24.
 */
public class FastJsonTest {
    public static void main(String[] args) {
        FastJsonBean bean1 = new FastJsonBean("001","textcode","xiaoyi");
        String text1 = JSON.toJSONString(bean1);
        System.out.println("xiaoyi是： "+text1);


        String beant =" {\"code\":\"textcode\",\"id\":\"002\",\"name\":\"xiaoer\"} ";


        FastJsonBean bean4 = JSON.parseObject(beant,FastJsonBean.class);
        System.out.println("xiaoyi是： "+JSON.toJSONString(bean4));




    }
}
