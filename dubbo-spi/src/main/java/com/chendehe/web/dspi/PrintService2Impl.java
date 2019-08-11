package com.chendehe.web.dspi;

/**
 * @author CDH
 * @since 2019.8.11 011 22:03
 */
public class PrintService2Impl implements PrintService {
    @Override
    public void printInfo() {
        System.out.println("Hello Dubbo spi2");
    }
}
