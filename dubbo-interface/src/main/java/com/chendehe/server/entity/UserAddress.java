package com.chendehe.server.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Data
@AllArgsConstructor
public class UserAddress implements Serializable {

    private Integer id;
    private String userAddress;
    private String userId;
    private String consignee;
    private String phoneNum;
    private String isDefault;

}
