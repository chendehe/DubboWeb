package com.chendehe.vo;

import java.util.Date;

import lombok.Data;

@Data
public class UserVo {

    private String id;
    private String name;
    private Integer gender;
    private Date birthday;
    private String address;
}
