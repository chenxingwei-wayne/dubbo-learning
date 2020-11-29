package org.apache.dubbo.dubbosamplesprovider.service.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.samples.bean.UserAddress;
import org.apache.dubbo.samples.service.UserService;
import org.springframework.context.annotation.ComponentScan;

import java.util.Arrays;
import java.util.List;

@Service
@ComponentScan
public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        System.out.println("now calling userServiceImpl");
        UserAddress userAddress1 = new UserAddress(1, "changpingqu", "1", "lilaoshi", "18688727506", "YES");
        UserAddress userAddress2 = new UserAddress(2, "tongzhouqu", "2", "wanglaoshi", "18688727506", "NO");
        return Arrays.asList(userAddress1, userAddress2);
    }
}
