package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.impl;

import org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.api.AsyncService;

public class AsyncServiceImpl implements AsyncService {
    @Override
    public String sayHello(String name) {
        System.out.println("async provider received: " + name);
        return "hello,  " + name;
    }

    @Override
    public String sayHelloTimeout(String name) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "timeout value";
    }
}
