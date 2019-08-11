package com.chendehe.server.service;

import java.util.List;

import com.chendehe.server.entity.UserAddress;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
public interface UserService {

    List<UserAddress> getUserAddress(String userId);

}
