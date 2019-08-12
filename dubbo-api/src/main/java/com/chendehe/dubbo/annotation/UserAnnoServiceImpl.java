package com.chendehe.dubbo.annotation;

import java.util.Arrays;
import java.util.List;

import org.apache.dubbo.config.annotation.Service;

import com.chendehe.server.entity.UserAddress;
import com.chendehe.server.service.UserDubboService;

/**
 * 注意使用 dubbo 的 @Service
 *
 * @author CDH
 * @since 2019.8.11 011 18:17
 */
@Service
public class UserAnnoServiceImpl implements UserDubboService {
    @Override
    public List<UserAddress> getUserAddress(String userId) {
        System.out.println("UserAnnoServiceImpl.....");
        // TODO Auto-generated method stub
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

        return Arrays.asList(address1, address2);
    }
}
