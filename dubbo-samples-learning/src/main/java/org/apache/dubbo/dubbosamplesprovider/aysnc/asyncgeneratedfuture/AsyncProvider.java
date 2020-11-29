package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncgeneratedfuture;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class AsyncProvider {
    public static void main(String[] args) throws InterruptedException {
        new EmbeddedZooKeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/async-provider.xml");
        context.start();
        System.out.println("dubbo services started.");
        new CountDownLatch(1).await();
    }
}
