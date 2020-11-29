package org.apache.dubbo.dubbosamplesprovider.cache.impl;

import org.apache.dubbo.dubbosamplesprovider.cache.api.CacheService;

import java.util.concurrent.atomic.AtomicInteger;

public class CacheServiceImpl implements CacheService {
    // 只要provider一直存在这个变量就一直有缓存。
    private final AtomicInteger i = new AtomicInteger();
    @Override
    public String findCache(String id) {
        return "request: " + id + ", response: " + i.getAndIncrement();
    }
}
