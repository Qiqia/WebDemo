package example.zsltest;

import com.alibaba.fastjson.JSON;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HttpCTest {
    public static void main(String[] args) throws Exception{
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://qr-test3.chinaums.com/netpay-route-server/api/");
        httpPost.setHeader("User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36");
        CloseableHttpResponse response = null;


//        设置请求数据
//        List<NameValuePair> params = new ArrayList<NameValuePair>();
//        params.add(new BasicNameValuePair("scope", "project"));
//        params.add(new BasicNameValuePair("q", "java"));
//        params.add(new BasicNameValuePair("fromerr", "7nXH76r7"));
//        //构建表单
//        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(params);
//        //将表达请求放入到httpost
//        httpPost.setEntity(formEntity);


        Map<String,String> bizMap = new HashMap<String, String>(){{
            put("mchntOrderId","order.getMerOrderId()");
//            if (StringUtils.isNotBlank(order.getGoodsTradeNo())) {
//                Goods[] goods = req.getGoods();
//                put("body", JSON.toJSONString(goods));
//                put("body", convertToAliGoodsDetails(goodsStoreService.getGoodsStore(order.getGoodsTradeNo())));
//            }
        }};
        String body = JSON.toJSONString(bizMap);


//        String body = "{" +
//                "  \"serviceId\": \"pip\",\n" +
//                "  \"key\": \"pipDnsLabel\",\n" +
//                "  \"value\": \"abcdefg\",\n" +
//                "  \"dependenceOn\": {\"pipLocation\":\"chinanorth\"}\n" +
//                "}";


        System.out.println("请求参数是："+body);

        httpPost.setEntity(new StringEntity(body, "UTF-8"));

        try {
            response = httpClient.execute(httpPost);
            String content = EntityUtils.toString(response.getEntity(), "utf-8");
            System.out.println(content);
        }finally{
            if(response!=null){
                response.close();
            }
            httpClient.close();
        }
    }
}
