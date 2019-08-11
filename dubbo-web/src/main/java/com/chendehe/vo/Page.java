package com.chendehe.vo;

import lombok.Data;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Data
public class Page {

    // 当前页
    private Integer currentPage;

    // 页面大小
    private Integer pageSize;

}
