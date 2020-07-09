package example.zsltest;

import com.alibaba.fastjson.JSONArray;
import net.sf.json.JSONObject;
import com.alibaba.fastjson.JSON;
import org.apache.commons.lang3.time.DateFormatUtils;

import java.util.Date;
import java.util.Map;
import java.util.*;

public class JsonMAx {
    public static void main(String[] args) {
        JSONObject json = new JSONObject();
        json.put("mid", "mid");
        json.put("tid", "tid");
        json.put("msgType", "msgType_order");
        json.put("msgSrc", "msgSrc");
        json.put("instMid", "instMid");
        json.put("merOrderId", "merOrderId");
        json.put("totalAmount", "totalAmount");
        json.put("tradeType", "MINI");


        JSONObject json1 = new JSONObject();
        json1.put("mid", "mid");
        JSONObject json2 = new JSONObject();
        json2.put("mid", "mid");
        JSONArray x = new JSONArray();
        x.add(json1);
        x.add(json2);
        json.put("dsf",x);

        //是否要在商户系统下单，看商户需求  createBill()
        json.put("requestTimestamp", DateFormatUtils.format(new Date(), "yyyy-MM-dd HH:mm:ss"));

        Map<String, String> paramsMap = jsonToMap(json);
//        paramsMap.put("sign", makeSign(md5Key, paramsMap));
        System.out.println("paramsMap："+paramsMap);

        String strReqJsonStr = JSON.toJSONString(paramsMap);
        System.out.println("strReqJsonStr:"+strReqJsonStr);
    }



    public static Map<String, String> jsonToMap(JSONObject json) {
        Map<String, String> map = new HashMap<>();
        for (Object key : json.keySet()) {
            String value = json.optString((String) key);
            map.put((String) key, value);
        }
        return map;
    }
}
