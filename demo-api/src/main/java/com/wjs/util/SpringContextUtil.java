package com.wjs.util;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * Created by 341039 on 2017/3/5.
 */
public class SpringContextUtil implements ApplicationContextAware {

    /* Spring应用上下文环境 */
    private static ApplicationContext applicationContext;

    /*
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     *
     * @param applicationContext
     *
     * @throws BeansException
     */
    public void setApplicationContext(ApplicationContext applicationContext)
            throws BeansException {
        SpringContextUtil.setApplicationContextInstanse(applicationContext);
    }

    /*
     * @Title: SpringContextUtil.java
     * @Package com.deppon.tak.module.waybill.common.util
     * @Description:
     * @author 323467
     * @date 2016-7-28 上午9:56:41
     * @version V1.0
     */
    private static void setApplicationContextInstanse(
            ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /*
     * @return ApplicationContext
     */
    public static ApplicationContext getApplicationContext() {
        return SpringContextUtil.applicationContext;
    }

    /*
     * 获取对象
     *
     * @param name
     *
     * @return Object 一个以所给名字注册的bean的实例
     *
     * @throws BeansException
     */
    public static Object getBean(String name) throws BeansException {
        return applicationContext.getBean(name);
    }

    /*
     * 获取类型为requiredType的对象
     * 如果bean不能被类型转换，相应的异常将会被抛出（BeanNotOfRequiredTypeException）
     *
     * @param name bean注册名
     *
     * @param requiredType 返回对象类型
     *
     * @return Object 返回requiredType类型对象
     *
     * @throws BeansException
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public static Object getBean(String name, Class requiredType)
            throws BeansException {
        return applicationContext.getBean(name, requiredType);
    }

    /*
     * 如果BeanFactory包含一个与所给名称匹配的bean定义，则返回true
     *
     * @param name
     *
     * @return boolean
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /*
     * 判断以给定名字注册的bean定义是一个singleton还是一个prototype。
     * 如果与给定名字相应的bean定义没有被找到，将会抛出一个异常（NoSuchBeanDefinitionException）
     *
     * @param name
     *
     * @return boolean
     *
     * @throws NoSuchBeanDefinitionException
     */
    public static boolean isSingleton(String name)
            throws NoSuchBeanDefinitionException {
        return applicationContext.isSingleton(name);
    }

    /*
     * @param name
     *
     * @return Class 注册对象的类型
     *
     * @author 200942
     * @date 2016-5-10 下午8:37:39
     * @throws NoSuchBeanDefinitionException
     */
    @SuppressWarnings("rawtypes")
    public static Class getType(String name)
            throws NoSuchBeanDefinitionException {
        return applicationContext.getType(name);
    }

    /*
     * 如果给定的bean名字在bean定义中有别名，则返回这些别名
     *
     * @param name
     *
     * @author 200942
     * @date 2016-5-10 下午8:37:39
     *
     * @throws NoSuchBeanDefinitionException
     */
    public static String[] getAliases(String name)
            throws NoSuchBeanDefinitionException {
        return applicationContext.getAliases(name);
    }
}
