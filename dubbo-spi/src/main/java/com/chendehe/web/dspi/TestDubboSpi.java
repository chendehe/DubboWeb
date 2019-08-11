package com.chendehe.web.dspi;

import com.alibaba.dubbo.common.extension.ExtensionLoader;
import java.util.ServiceLoader;

/**
 * Dubbo SPI 测试类
 *
 * @author CDH
 * @since 2019.8.11 011 22:02
 */
public class TestDubboSpi {
    public static void main(String[] args) {
        PrintService printService = ExtensionLoader.getExtensionLoader(PrintService.class).getDefaultExtension();
        printService.printInfo();
    }
}
