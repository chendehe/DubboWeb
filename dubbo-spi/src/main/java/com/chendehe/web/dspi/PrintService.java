package com.chendehe.web.dspi;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.Adaptive;
import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author CDH
 * @since 2019.8.11 011 22:03
 */
@SPI("myImpl2")
public interface PrintService {

    @Adaptive({"key"})
    void printInfo(URL url);
}
