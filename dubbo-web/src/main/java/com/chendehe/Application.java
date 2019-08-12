package com.chendehe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.FilterType;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@SpringBootApplication
@ComponentScan(excludeFilters = {@Filter(type = FilterType.REGEX, pattern = {"com.chendehe.dubbo.*"})})
// 加了 starter 后可删除 @EnableDubbo(scanBasePackages = "com.chendehe.service")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // 加了 starter 后可删除
    // @Configuration
    // @PropertySource("classpath:dubbo-consumer.properties")
    // static public class ConsumerConfiguration {
    //
    // }
    //
    // @Configuration
    // @PropertySource("classpath:dubbo-provider.properties")
    // static public class ProviderConfiguration {
    //
    // }
}
