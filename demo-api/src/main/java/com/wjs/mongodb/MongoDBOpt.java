package com.wjs.mongodb;

import com.mongodb.*;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.util.DBObjectUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by 341039 on 2017/4/26.
 */
@Component
public class MongoDBOpt {
    @Resource
    public MongoTemplate mongoTemplate;

    public void queryMongoqueryMongo(){
        DB db=mongoTemplate.getDb();
        System.out.println(db.getName());
        CommandResult commandResult=db.getStats();
        DBCollection collection= db.getCollectionFromString("mydb");
        DBObject dbObject=collection.find().getQuery();
        System.out.println(dbObject.toString());

        Set<Entry<String,Object>> set=commandResult.entrySet();
        for (Entry<String,Object> map:set) {
            System.out.println("key:\t"+map.getKey());
            System.out.println("value:\t"+map.getValue());
        }
    }

    public void insertMonogo(){

        DB db= mongoTemplate.getDb();
        for (String names:db.getCollectionNames()) {
            System.out.println("names:\t"+names);
        }
        DBCollection dbCollection=db.getCollection("mydb");
        Map<String,Object> map =new HashedMap();
        map.put("name","person2");
        map.put("age",44);
        map.put("personObj","jack");
        dbCollection.insert(new BasicDBObject(map));
    }

    public void insert(){
        mongoTemplate.insert(new Person("name22",00),"mydb");
    }
}
