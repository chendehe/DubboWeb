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
@ComponentScan(excludeFilters = {
    @Filter(type = FilterType.REGEX, pattern = {"com.chendehe.dubbo.*"})
})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
