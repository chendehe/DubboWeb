package com.chendehe.vo;

import lombok.Data;

@Data
public class ErrorResult {

    private String errorMessage;
    private String errorDetail;

    public ErrorResult(String errorMessage, String errorDetail) {
        this.errorMessage = errorMessage;
        this.errorDetail = errorDetail;
    }

}
