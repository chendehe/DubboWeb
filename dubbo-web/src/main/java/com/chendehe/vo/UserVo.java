package com.chendehe.vo;

import java.util.Date;

import lombok.Data;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Data
public class UserVo {

    private String id;
    private String name;
    private Integer gender;
    private Date birthday;
    private String address;
}
