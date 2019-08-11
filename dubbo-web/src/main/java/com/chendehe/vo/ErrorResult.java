package com.chendehe.vo;

import lombok.Data;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Data
public class ErrorResult {

    private String errorMessage;
    private String errorDetail;

    public ErrorResult(String errorMessage, String errorDetail) {
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

}
