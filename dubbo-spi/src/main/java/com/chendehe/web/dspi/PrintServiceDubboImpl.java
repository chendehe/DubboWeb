package com.chendehe.web.dspi;

import com.alibaba.dubbo.common.URL;

/**
 * @author CDH
 * @since 2019.8.11 011 22:03
 */
public class PrintServiceDubboImpl implements PrintService {
    @Override
    public void printInfo(URL url) {
        System.out.println("Hello Dubbo spi Dubbo" + url);
    }
}
