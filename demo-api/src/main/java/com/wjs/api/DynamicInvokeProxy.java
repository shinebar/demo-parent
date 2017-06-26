package com.wjs.api;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by 341039 on 2016/12/9.
 */
public class DynamicInvokeProxy {

    //调用类的class
    private Class cls;
    //调用的方法名
    private String methodName;
    //调用方法传入的参数类型
    private Object paramType;
    //调用方法参数
    //private Object args;
    //private Object argsValue;
    /**
     * 无参构造方法
     */
    public DynamicInvokeProxy(){}

    /**
     *
     * @param cls  类.class
     * @param paramType   参数类型列表
     * @param mapArgs        实际参数列表
     */
    public DynamicInvokeProxy(Class cls, Object paramType, Object mapArgs){
        this.cls=cls;
        this.methodName=methodName;
        this.paramType=paramType;
        //this.args=args;
       // resolveMapArgs(mapArgs);
    }
    /**
     *封闭私用方法，使用反射统一调用
     * @param paramArgs methodName参数要传入的实参
     */
/*    private Object invokePointMethod(Object paramArgs) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object ojb= null;
        Method method= null;
        //调用无参方法
        if (paramType==void.class){
            method=cls.getDeclaredMethod(methodName,null);
            ojb = method.invoke(cls.newInstance());
        }else{
            //调用有参数方法
            method = cls.getMethod(methodName,paramType);
            ojb = method.invoke(cls.newInstance(),paramArgs);
        }

        return ojb;
    }*/

    /**
     *封装用方法，使用反射统一调用
     */
    public Object invokePointMethod(String methodName, Class<?> paramType, Object args) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Object ojb= null;
        Method method= null;
        //调用无参方法
        if (paramType==void.class){
            method=cls.getDeclaredMethod(methodName,null);
            ojb = method.invoke(cls.newInstance());
        }else{
            //调用有参数方法
            method = cls.getMethod(methodName,paramType);
            ojb = method.invoke(cls.newInstance(),args);
        }
        return ojb;
    }

}
