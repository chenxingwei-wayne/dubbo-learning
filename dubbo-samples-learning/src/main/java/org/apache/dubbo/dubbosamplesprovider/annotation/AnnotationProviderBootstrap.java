package org.apache.dubbo.dubbosamplesprovider.annotation;

import org.apache.dubbo.dubbosamplesprovider.annotation.config.ProviderConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.concurrent.CountDownLatch;

public class AnnotationProviderBootstrap {
    public static void main(String[] args) throws InterruptedException {
        new EmbeddedZooKeeper(2181, false).start();
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProviderConfiguration.class);
        context.start();
        System.out.println("dubbo service started.");
        new CountDownLatch(1).await();
    }
}
