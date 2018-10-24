package example.zsltest;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by zsl on 2018/10/24.
 */
@Getter
@Setter
public class FastJsonBean {
    private String id;
    private String code;
    private String name;

    public FastJsonBean(String id,String code,String name){
        this.id = id;
        this.name = name;
        this.code = code;
    }
}
