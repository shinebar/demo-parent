package com.wjs.controller;


import com.wjs.service.BeanLocalCycle;
import org.apache.commons.collections.iterators.ArrayIterator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.InternalResourceView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by 341039 on 2016/11/1.
 */
@Controller
public class UserController {

    @Autowired
    private BeanLocalCycle beanLocalCycle;
    @RequestMapping(value = "/hello")
    public ModelAndView printWelcome(HttpServletRequest request, HttpServletResponse response) {
        ModelAndView mav = new ModelAndView();
        mav.addObject("message", "welcome to velocity!");
        mav.setViewName("/hello");
        System.out.println("dddd");
        beanLocalCycle.doGlobalSomeThing();
        beanLocalCycle.dolocalSomething();
        System.out.println("beanLocal\t"+beanLocalCycle);
        return mav;
    }

    @RequestMapping(value = "index")
    public ModelAndView index(HttpServletRequest request ,HttpServletResponse response){
        ModelAndView mav=new ModelAndView();
        mav.addObject("messge","index jsp welcome");
        mav.setViewName("/index");
        return mav;
    }

    public void setBeanLocalCycle(BeanLocalCycle beanLocalCycle) {
        this.beanLocalCycle = beanLocalCycle;
    }
}
