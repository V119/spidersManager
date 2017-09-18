package com.sicdlib.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by DeMH on 2017/5/9.
 */
public class HBaseInitListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        //因为首次初始化hbase的连接比较耗时，所以打算随着tomcat启动就自动加载hbase的工具类
        try {
            Class.forName("com.sicdlib.util.HBaseUtil.HBaseData");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
    }
}
