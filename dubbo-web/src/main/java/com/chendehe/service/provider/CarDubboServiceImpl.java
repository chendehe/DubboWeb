package com.chendehe.service.provider;

import org.apache.dubbo.config.annotation.Service;

import com.chendehe.server.service.CarDubboService;
import org.springframework.beans.factory.annotation.Value;

/**
 * 注意使用 dubbo 的 @Service
 *
 * @author CDH
 * @since 2019.8.11 011 18:17
 */
@Service
public class CarDubboServiceImpl implements CarDubboService {

    @Value("${spring.application.name}")
    private String serviceName;
    
    @Override
    public String getCarName(String id) {
        return "MY CAR:" + serviceName;
    }
}
