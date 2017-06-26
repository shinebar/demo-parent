package com.wjs.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by 341039 on 2017/3/11.
 */
public class FactoryBeanSelfBean implements FactoryBean,InitializingBean{
    private Logger logger=LoggerFactory.getLogger(FactoryBeanSelfBean.class);
    private Resource dirAddress;
    private String addrePrefix;
    private String keyValue;

    public FactoryBeanSelfBean getObject() throws Exception {
        return new FactoryBeanSelfBean();
    }

    public Class<?> getObjectType() {
        return FactoryBeanSelfBean.class;
    }

    public boolean isSingleton() {
        return true;
    }

    public void afterPropertiesSet() throws Exception {
        try{
          Properties properties=new Properties();
            properties.load(dirAddress.getInputStream());
            if (addrePrefix.startsWith(addrePrefix)){
                keyValue=properties.getProperty(addrePrefix);
            }
            System.out.println(keyValue);
            System.out.println(addrePrefix);
        }catch(Exception e){
            logger.info("dddsfs{0}",e);
        }
    }

    public void setAddrePrefix(String addrePrefix) {
        this.addrePrefix = addrePrefix;
    }

    public String getAddrePrefix(){
        return addrePrefix;
    }
    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public void setDirAddress(Resource dirAddress) {
        this.dirAddress = dirAddress;
    }
}
