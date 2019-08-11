package com.chendehe.web.jspi;

import java.util.ServiceLoader;

/**
 * Java SPI 测试类
 *
 * @author CDH
 * @since 2019.8.11 011 22:02
 */
public class Test {
    public static void main(String[] args) {
        ServiceLoader<PrintService> serviceLoader = ServiceLoader.load(PrintService.class);
        serviceLoader.forEach(PrintService::printInfo);
    }
}
