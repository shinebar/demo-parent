package com.wjs.api;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by 341039 on 2017/3/21.
 */
public class ReflectCase {

    public static void main(String[] args) throws Exception {
        Proxy target = new Proxy();
        Method method = Proxy.class.getDeclaredMethod("run");
        Class[] cls=ReflectCase.class.getMethod("paramType",String.class).getParameterTypes();
        String name=cls[0].getSimpleName();
        System.out.println("ddaf\t"+name);
        method.invoke(target);
       Class lass= Class.forName("com.wjs.api.ReflectCase");
        Method methods=lass.getMethod("paramType",String.class);
        System.out.println(methods.getParameters()[0].getName());
    }

    static class Proxy {
        public void run() {
            System.out.println("run");
        }
    }
    public void paramType(String name){
        System.out.println("fdsfs"+name);
    }
}

