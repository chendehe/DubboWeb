package com.chendehe.dubbo.dynamic;

import java.io.IOException;

import org.apache.dubbo.config.ConfigCenterConfig;
import org.apache.dubbo.config.builders.ConfigCenterBuilder;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author CDH
 * @since 2019.8.12 012 17:42
 */
public class DynamicProvider {
    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        System.out.println("Dubbo provider start at " + context.getStartupDate());

        System.out.println(System.in.read());
    }

    @Configuration
    @EnableDubbo(scanBasePackages = "com.chendehe.dubbo.annotation")
    static class ProviderConfiguration {
        @Bean
        ConfigCenterConfig configCenterConfig() {
            return new ConfigCenterBuilder().address("zookeeper://127.0.0.1:2181").build();
        }
    }

}
