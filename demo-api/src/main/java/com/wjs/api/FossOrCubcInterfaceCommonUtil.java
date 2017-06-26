package com.wjs.api;

import org.apache.commons.lang.StringUtils;

import java.util.Iterator;
import java.util.Map;
import java.util.Random;

/**
 * Created by 341039 on 2016/12/10.
 */
public class FossOrCubcInterfaceCommonUtil {
    public static final String CUBC="cubc";
    public static final String FOSS="foss";
    public static final String ALL="all";
    private DynamicInvokeProxy proxy=null;

    private Object args;
    private Object argsValue;
    private Class cls;
    private String methodName;
    private Object paramType;
    private String invokeFlag;
    private Class<?> cubcParamType;
    private Class<?> fossParamType;

    /**
     * @des 调用适配层接口，确定走哪个系统
     * @return
     */
    public static String stepIntoInterface(){
        int d= new Random().nextInt(1000);
        System.out.println(d);
        if (d>0 && d <200){
            return CUBC;
        }else if (d>301 && d<600){
            return FOSS;
        }
        return ALL;
    }

    public FossOrCubcInterfaceCommonUtil(){}
    /**
     *
     * @param cls  类.class
     * @param paramType   参数类型列表
     * @param mapArgs     实际参数列表
     */
    public FossOrCubcInterfaceCommonUtil(Class cls, Object paramType, Object mapArgs){
        this.cls=cls;
        this.methodName=methodName;
        this.paramType=paramType;
        resolveArgs(paramType,mapArgs);
    }
    //FOSS接口;CUBC接口,或者都要调用
    public Object invokeAllMethod()  {

        //调用适配层方法
        this.invokeFlag=stepIntoInterface();
        //根据适配层返回参数不同，调用不同参数
        if (StringUtils.isNotBlank(invokeFlag)){
            proxy=new DynamicInvokeProxy(cls,paramType,this.args);
            //调用CUBC接口方法
            if (CUBC.equals(this.invokeFlag)){
                try {
                    return proxy.invokePointMethod(CUBC,this.cubcParamType,this.args);//设置调用CUBC方法
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //调用FOSS接口方法
            if (FOSS.equals(this.invokeFlag)){
                try {
                    return proxy.invokePointMethod(FOSS,fossParamType,this.argsValue);//调用调用FOSS方法
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            //两都都要既走CUBC,又走FOSS，但是返回参数FOSS
            if (ALL.equals(this.invokeFlag)){
                try {
                    proxy.invokePointMethod(CUBC,cubcParamType,this.args);

                } catch (Exception e) {
                  e.printStackTrace();
                }
                try{
                    return proxy.invokePointMethod(FOSS,fossParamType,this.argsValue);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    //调用参数类型的不同，解析出不同参数
    private void resolveArgs(Object paramType, Object args) {
        //应调方法参数类型为Map,而args类型为map
        System.out.println(paramType instanceof Map);
        if (paramType instanceof Map){
            resolveMapArgs(paramType,args);
        }else{
            throw new IllegalArgumentException("参数类型不是Map");
        }

    }

    /**
     * 解析出方法的入参，即实参
     * @param  mapArgs
     */
    private void resolveMapArgs(Object paramType, Object mapArgs){
        Map param=(Map)paramType;
        Map map=null;
        if (mapArgs instanceof Map){
            map=(Map)mapArgs;
        }else{
            throw new IllegalArgumentException("实参列表不合法");
        }

        Iterator iterator =map.keySet().iterator();
        while (iterator.hasNext()){
            Object key= iterator.next();
            //System.out.println(key);
            if (FossOrCubcInterfaceCommonUtil.CUBC.equals(key)){
                this.args=map.get(key);//设置调用CUBC方法的参数
                this.cubcParamType= (Class<?>) param.get(key);
            }
            if (FossOrCubcInterfaceCommonUtil.FOSS.equals(key)){
                this.argsValue=map.get(key);//调用调用FOSS方法的参数
                this.fossParamType=(Class<?>) param.get(key);
            }
        }
    }
    public static void main(String[] args){
        System.out.println(stepIntoInterface());

    }
}
