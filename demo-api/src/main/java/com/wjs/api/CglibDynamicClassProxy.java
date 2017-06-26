package com.wjs.api;

import org.springframework.cglib.proxy.CallbackFilter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by 341039 on 2016/12/9.
 */
public class CglibDynamicClassProxy implements MethodInterceptor {
    //
    private Enhancer enhancer=new Enhancer();
    public Object cglibProxy(Class cls){
        enhancer.setSuperclass(cls);
        enhancer.setCallback(this);
        enhancer.setCallbackFilter(new myCallbackFilter());
        return enhancer.create();
    }


    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("前置通知");
        System.out.println(method.getName());
        Object result = methodProxy.invokeSuper(o,objects);
        System.out.println("后置通知");
        return result;
    }
    private class myCallbackFilter implements CallbackFilter {
        public int accept(Method method) {
            return 0;
        }
    }
}
