package example.service.impl;

import example.service.SList;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public class NoWebClass {
    @Autowired
    private List<SList> sLists;

    @Autowired
    private Map<String,SList> stringSListMap;

    public void say(){
        for(SList sList:sLists){
            sList.say();
        }

        for (Map.Entry<String,SList> entry:stringSListMap.entrySet()){
            System.out.println(entry.getKey());
            entry.getValue().say();
        }
    }
}
