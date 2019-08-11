package com.chendehe.dubbo.annotation;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ConsumerConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;

/**
 * @author CDH
 * @since 2019.8.11 011 18:28
 */
public class AnnotationConsumer {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ConsumerConfiguration.class);

        context.start();
        ConsumerService consumerService = context.getBean(ConsumerService.class);
        consumerService.consumerHello("hahahaha");

        context.stop();
    }

    /**
     * 注入：ConsumerConfig、ApplicationConfig、RegistryConfig，少了 ProtocolConfig
     */
    @Configuration
    @EnableDubbo(scanBasePackages = "com.chendehe.dubbo.annotation")
    @ComponentScan(basePackages = "com.chendehe.dubbo.annotation")
    @Import(ConsumerConfig.class)
    static class ConsumerConfiguration {

        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-consumer-annotation");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setProtocol("zookeeper");
            registryConfig.setAddress("localhost");
            registryConfig.setPort(2181);
            return registryConfig;
        }
    }
}
