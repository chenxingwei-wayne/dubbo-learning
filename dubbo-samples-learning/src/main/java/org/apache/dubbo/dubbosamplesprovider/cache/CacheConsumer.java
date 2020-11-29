package org.apache.dubbo.dubbosamplesprovider.cache;

import org.apache.dubbo.dubbosamplesprovider.cache.api.CacheService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CacheConsumer {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/cache-consumer.xml");
        context.start();
        CacheService cacheService = (CacheService) context.getBean("cacheService");
        String fix = null;
        for (int i = 0; i < 5; i++) {
            String result = cacheService.findCache("0");
            if (fix == null || fix.equals(result)) {
                System.out.println("OK: " + result);
            } else {
                System.err.println("Error: " + result);
            }
            fix = result;
            Thread.sleep(500);
        }
    }
}
