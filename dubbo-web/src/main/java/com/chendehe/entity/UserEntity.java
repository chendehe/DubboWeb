package com.chendehe.entity;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Data
public class UserEntity implements BaseEntity, Serializable {

    private static final long serialVersionUID = -2535178899662614143L;
    private String id;
    private String name;
    private int gender;
    private Date birthday;
    private String address;
    private Date createTime;
    private Date updateTime;

}
