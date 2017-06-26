package com.wjs.mongodb;

import com.mongodb.DB;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by 341039 on 2017/4/26.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:config/applicationContext.xml"})
public class MongoDBOptTest {

    @Resource
    public  MongoDBOpt mongoDBOpt;

    @Test
    public void testQuery(){
        mongoDBOpt.queryMongoqueryMongo();

    }
    @Test
    public void insertMongo(){
        mongoDBOpt.insertMonogo();
    }
    @Test
    public void testInsert(){
        mongoDBOpt.insert();
    }

}
