package com.chendehe.dubbo.api;

import java.util.List;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.chendehe.server.entity.UserAddress;
import com.chendehe.server.service.UserDubboService;

/**
 * API 方式的消费者，比较灵活，可以与第三方框架集成，特别适合动态消费场景。 在 Dubbo 框架中典型的使用场景就是泛化调用，可以指定一个本地不存在的接口发器 RPC，通过 API 方式最简洁。
 *
 * @author CDH
 * @since 2019.8.11 011 19:08
 */
public class ApiConsumer {
    public static void main(String[] args) {
        ReferenceConfig<UserDubboService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("dubbo-consumer-api"));
        reference.setRegistry(new RegistryConfig("zookeeper://localhost:2181"));
        // 指定要消费的服务接口
        reference.setInterface(UserDubboService.class);
        // 创建远程连接并做动态代理转换
        UserDubboService userService = reference.get();
        List<UserAddress> addressList = userService.getUserAddress("123");

        addressList.forEach(System.out::println);
    }
}
