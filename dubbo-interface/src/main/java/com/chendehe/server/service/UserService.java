package com.chendehe.server.service;

import java.util.List;

import com.chendehe.server.bean.UserAddress;

/**
 * 用户服务
 *
 * @author lfy
 */
public interface UserService {

    /**
     * 按照用户id返回所有的收货地址
     */
    public List<UserAddress> getUserAddressList(String userId);

}
