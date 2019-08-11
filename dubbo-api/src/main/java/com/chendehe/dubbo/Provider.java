package com.chendehe.dubbo;

import java.io.IOException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
public class Provider {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"provider.xml"});
        context.start();

        System.out.println("Dubbo provider start at " + context.getStartupDate());

        try {
            int i = System.in.read();// 按任意键退出
            System.out.println("End: " + i);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            context.stop();
        }

    }
}