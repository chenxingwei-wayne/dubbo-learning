package org.apache.dubbo.dubbosamplesprovider.callback;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CountDownLatch;

public class CallbackProvider {
    public static void main(String[] args) throws InterruptedException {
        new EmbeddedZooKeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/callback-provider.xml");
        context.start();
        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
