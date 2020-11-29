package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class AsyncProvider {
    public static void main(String[] args) throws InterruptedException {
        new EmbeddedZooKeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/async-provider.xml");
        context.start();
        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
