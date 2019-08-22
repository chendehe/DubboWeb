package com.chendehe.dubbo.annotation;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ConsumerConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author CDH
 * @since 2019.8.11 011 18:28
 */
public class AnnotationConsumer {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ConsumerConfiguration.class);

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
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }
    }
}
