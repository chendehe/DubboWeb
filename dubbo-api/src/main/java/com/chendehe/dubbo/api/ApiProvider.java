package com.chendehe.dubbo.api;

import java.io.IOException;

import org.apache.dubbo.config.ApplicationConfig;
import org.apache.dubbo.config.RegistryConfig;
import org.apache.dubbo.config.ServiceConfig;

import com.chendehe.server.service.UserDubboService;

/**
 * 基于 API 开发的提供者。 不常用，但是某些场景很有用，比如开发网关类的产品，需要动态消费不同版本的服务，通过 API 方式， 可以根据前端请求参数动态构造不同版本的服务实例等。
 *
 * @author CDH
 * @since 2019.8.11 011 19:02
 */
public class ApiProvider {
    public static void main(String[] args) throws IOException {
        ServiceConfig<UserDubboService> service = new ServiceConfig<>();
        service.setApplication(new ApplicationConfig("dubbo-provider-api"));
        service.setRegistry(new RegistryConfig("zookeeper://localhost:2181"));
        // 指定服务暴露的接口
        service.setInterface(UserDubboService.class);
        // 指定真实服务对象
        service.setRef(new UserApiServiceImpl());
        // 暴露服务
        service.export();

        System.out.println("ApiProvider started");

        System.out.println(System.in.read());
    }
}
