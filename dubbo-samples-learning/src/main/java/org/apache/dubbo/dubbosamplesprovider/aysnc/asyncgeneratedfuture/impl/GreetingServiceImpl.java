package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncgeneratedfuture.impl;

import org.apache.dubbo.dubbosamplesprovider.aysnc.asyncgeneratedfuture.api.GreetingService;

public class GreetingServiceImpl implements GreetingService {
    @Override
    public String greeting(String name) {
        System.out.println("provider received: " + name);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("provider returned.");
        return replyGreeting(name);
    }
}
