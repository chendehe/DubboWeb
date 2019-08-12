package com.chendehe.web.dspi;

import java.util.Arrays;
import java.util.List;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.rpc.Filter;

/**
 * Dubbo SPI 测试类
 *
 * @author CDH
 * @since 2019.8.11 011 22:02
 */
public class TestDubboSpi {
    public static void main(String[] args) {

        ExtensionLoader<PrintService> loader = ExtensionLoader.getExtensionLoader(PrintService.class);

        // 只取 @SPI 默认的
        PrintService defaultExtension = loader.getDefaultExtension();
        defaultExtension.printInfo(URL.valueOf("test://localhost/test"));
        defaultExtension.printInfo(URL.valueOf("test://localhost/test?key=myImpl"));

        // 自适应
        PrintService printService = loader.getAdaptiveExtension();
        printService.printInfo(URL.valueOf("test://localhost/test"));
        printService.printInfo(URL.valueOf("test://localhost/test?key=myImpl"));

        // 自动激活
        ExtensionLoader<Filter> filterLoader = ExtensionLoader.getExtensionLoader(Filter.class);
        URL url1 = URL.valueOf("test://localhost/test?generic=true");
        List<Filter> filters = filterLoader.getActivateExtension(url1, new String[] {}, Constants.CONSUMER);
        System.out.println("size: " + filters.size() + "---" + Arrays.toString(filters.toArray(new Filter[0])));

        URL url2 = URL.valueOf("test://localhost/test?generic=true&filter2=true");
        List<Filter> filters2 = filterLoader.getActivateExtension(url2, new String[] {}, Constants.CONSUMER);
        System.out.println("size: " + filters2.size() + "---" + Arrays.toString(filters2.toArray(new Filter[0])));

        List<Filter> filters3 = filterLoader.getActivateExtension(url1,
            new String[] {Constants.REMOVE_VALUE_PREFIX + Constants.DEFAULT_KEY, "filter1", "filter2"});
        System.out.println("size: " + filters3.size() + "---" + Arrays.toString(filters3.toArray(new Filter[0])));
    }
}
