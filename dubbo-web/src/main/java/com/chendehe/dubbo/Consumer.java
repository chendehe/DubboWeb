package com.chendehe.dubbo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.chendehe.dubbo.demo.ConsumerService;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
public class Consumer {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"consumer.xml"});
        context.start();

        ConsumerService consumerService = context.getBean(ConsumerService.class);
        consumerService.consumerHello("consumerService");

        context.stop();
        // try {
        // int i = System.in.read();// 按任意键退出
        // System.out.println("End: " + i);
        // } catch (IOException e) {
        // e.printStackTrace();
        // } finally {
        // context.stop();
        // }

    }
}