package com.chendehe.web.dspi;

import org.apache.dubbo.common.URL;

/**
 * @author CDH
 * @since 2019.8.11 011 22:03
 */
public class PrintServiceInternalImpl implements PrintService {
    @Override
    public void printInfo(URL url) {
        System.out.println("Hello Dubbo spi Internal" + url);
    }
}
