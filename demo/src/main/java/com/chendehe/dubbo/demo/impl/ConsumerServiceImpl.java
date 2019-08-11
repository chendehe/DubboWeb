package com.chendehe.dubbo.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chendehe.dubbo.demo.ConsumerService;
import com.chendehe.server.entity.UserAddress;
import com.chendehe.server.service.UserService;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final UserService userService;

    public ConsumerServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void consumerHello(String consumer) {
        List<UserAddress> addressList = userService.getUserAddress("test");

        addressList.forEach(System.out::println);
    }
}
