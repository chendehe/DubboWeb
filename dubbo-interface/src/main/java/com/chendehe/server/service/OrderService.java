package com.chendehe.server.service;

import java.util.List;

import com.chendehe.server.bean.UserAddress;

public interface OrderService {

    /**
     * 初始化订单
     */
    public List<UserAddress> initOrder(String userId);

}
