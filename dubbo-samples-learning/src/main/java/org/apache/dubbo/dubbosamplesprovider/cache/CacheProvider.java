package org.apache.dubbo.dubbosamplesprovider.cache;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class CacheProvider {
    public static void main(String[] args) throws InterruptedException {
        new EmbeddedZooKeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/cache-provider.xml");
        context.start();
        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
