package com.wjs.service;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by 341039 on 2017/3/9.
 */
public class BeanLocalCycle {

    private Map<String,Object> map=new HashedMap();

    public void doGlobalSomeThing(){
        map.put("foss","foss");
    }

    public void dolocalSomething(){
        Map<String,Object> localMap=new HashedMap();
        localMap.put("cubc","cubc");
    }

}
