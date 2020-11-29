package org.apache.dubbo.dubbosamplesprovider.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.samples.bean.UserAddress;
import org.apache.dubbo.samples.service.UserService;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

/**
 * SpringBoot与dubbo整合的三种方式：
 * 1. 导入dubbo-starter，在application.properties配置属性，使用@Service暴露服务，使用@Reference引用服务。
 * 2. 保留dubbo.xml配置文件，在xml中配置，取消@EnableDubbo注解，使用@ImportResource引入配置文件。
 * 3. 使用注解config的方式。
 */
@Service
@ComponentScan
public class UserServiceImpl2 implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("now calling userServiceImpl2");
        UserAddress userAddress1 = new UserAddress(1, "changpingqu", "1", "lilaoshi", "18688727506", "YES");
        UserAddress userAddress2 = new UserAddress(2, "tongzhouqu", "2", "wanglaoshi", "18688727506", "NO");
        return Arrays.asList(userAddress1, userAddress2);
    }
}
