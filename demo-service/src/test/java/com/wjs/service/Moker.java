package com.wjs.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 341039 on 2017/3/20.
 */
public class Moker<T extends Exception> {

    private static final List<String> NAMES=new ArrayList<String>(){
        {       add("JHON");
                System.out.println(NAMES);
        }
    };
    private void pleaseThrow(final Exception t) throws T{
        throw (T)t;
    }

    public static void main(String[] args) {
        new Moker<RuntimeException>().pleaseThrow(new SQLException());
        System.out.println(NAMES);
    }
}
