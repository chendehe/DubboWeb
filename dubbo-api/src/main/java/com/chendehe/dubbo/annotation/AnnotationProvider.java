package com.chendehe.dubbo.annotation;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.ProtocolConfig;
import org.apache.dubbo.config.ProviderConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * 注解方式的提供者
 *
 * @author CDH
 * @since 2019.8.11 011 18:18
 */
public class AnnotationProvider {

    public static void main(String[] args) throws IOException {
        AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();

        System.out.println("Dubbo provider start at " + context.getStartupDate());

        System.out.println(System.in.read());
    }

    /**
     * 注入：ProviderConfig、ApplicationConfig、RegistryConfig、ProtocolConfig
     */
    @Configuration
    @EnableDubbo(scanBasePackages = "com.chendehe.dubbo.annotation")
    @Import(ProviderConfig.class)
    static class ProviderConfiguration {
        @Bean
        public ApplicationConfig applicationConfig() {
            ApplicationConfig applicationConfig = new ApplicationConfig();
            applicationConfig.setName("dubbo-provider-annotation");
            return applicationConfig;
        }

        @Bean
        public RegistryConfig registryConfig() {
            RegistryConfig registryConfig = new RegistryConfig();
            registryConfig.setAddress("zookeeper://127.0.0.1:2181");
            return registryConfig;
        }

        @Bean
        public ProtocolConfig protocolConfig() {
            ProtocolConfig protocolConfig = new ProtocolConfig();
            protocolConfig.setName("dubbo");
            protocolConfig.setPort(20880);
            return protocolConfig;
        }
    }
}
