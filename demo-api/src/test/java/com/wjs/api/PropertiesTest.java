package com.wjs.api;

import com.sun.org.apache.xpath.internal.SourceTree;
import com.wjs.util.FactoryBeanSelfBean;
import junit.framework.TestCase;
import org.apache.commons.lang.ArrayUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by 341039 on 2017/3/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/applicationContext.xml"})
public class PropertiesTest {
    private Logger logger= LoggerFactory.getLogger(PropertiesTest.class);
    @Autowired
    private FactoryBeanSelfBean factoryBeanSelfBean;
    @Test
    public void testProperties(){
        try {
            factoryBeanSelfBean.afterPropertiesSet();
            System.out.println(factoryBeanSelfBean.getObjectType());
            System.out.println(factoryBeanSelfBean.getObject());
            System.out.println(factoryBeanSelfBean.getAddrePrefix());
           boolean[] b= ArrayUtils.toPrimitive(new Boolean[]{true,false});
            for (boolean ool:b
                 ) {
                System.out.println(ool);
            }
        }catch (Exception e){
            logger.info("ddaaa{0}",e);
        }
    }
}
