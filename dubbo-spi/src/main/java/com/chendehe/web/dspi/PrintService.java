package com.chendehe.web.dspi;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.common.extension.Adaptive;
import org.apache.dubbo.common.extension.SPI;

/**
 * @author CDH
 * @since 2019.8.11 011 22:03
 */
@SPI("myImpl2")
public interface PrintService {

    /**
     * 优先级比 @SPI 高
     */
    @Adaptive({"key"})
    void printInfo(URL url);
}
