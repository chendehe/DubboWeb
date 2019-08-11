package com.chendehe.dubbo.xml;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 基于配置文件的提供方
 * 
 * @author CDH
 * @since 2019/8/11 16:10
 */
public class Provider {

    public static void main(String[] args) throws IOException {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
        context.start();

        System.out.println("Dubbo provider start at " + context.getStartupDate());

        System.out.println(System.in.read());

    }
}