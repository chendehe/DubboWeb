package com.chendehe.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class PageResult<T> extends Page {

    // 总数
    private Integer totalNum;

    private List<T> list;

}
