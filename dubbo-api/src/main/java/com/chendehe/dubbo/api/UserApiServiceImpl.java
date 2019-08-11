package com.chendehe.dubbo.api;

import java.util.Arrays;
import java.util.List;

import com.chendehe.server.entity.UserAddress;
import com.chendehe.server.service.UserDubboService;

/**
 *
 * @author CDH
 * @since 2019.8.11 011 18:17
 */
public class UserApiServiceImpl implements UserDubboService {
    @Override
    public List<UserAddress> getUserAddress(String userId) {
        System.out.println("UserApiServiceImpl.....");
        // TODO Auto-generated method stub
        UserAddress address1 = new UserAddress(1, "北京市昌平区宏福科技园综合楼3层", "1", "李老师", "010-56253825", "Y");
        UserAddress address2 = new UserAddress(2, "深圳市宝安区西部硅谷大厦B座3层（深圳分校）", "1", "王老师", "010-56253825", "N");

        return Arrays.asList(address1, address2);
    }
}
