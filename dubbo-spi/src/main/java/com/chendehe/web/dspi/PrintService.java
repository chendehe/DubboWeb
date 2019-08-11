package com.chendehe.web.dspi;

import com.alibaba.dubbo.common.extension.SPI;

/**
 * @author CDH
 * @since 2019.8.11 011 22:03
 */
@SPI("myImpl")
public interface PrintService {
    void printInfo();
}
