package com.chendehe.dubbo.xml.demo.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chendehe.dubbo.xml.demo.ConsumerService;
import com.chendehe.server.entity.UserAddress;
import com.chendehe.server.service.UserDubboService;

/**
 *
 * @author CDH
 * @since 2019/8/11 16:10
 */
@Service
public class ConsumerServiceImpl implements ConsumerService {

    private final UserDubboService userDubboService;

    public ConsumerServiceImpl(UserDubboService userDubboService) {
        this.userDubboService = userDubboService;
    }

    @Override
    public void consumerHello(String consumer) {
        List<UserAddress> addressList = userDubboService.getUserAddress("test");

        addressList.forEach(System.out::println);
    }
}
