package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncgeneratedfuture;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.apache.dubbo.dubbosamplesprovider.aysnc.asyncgeneratedfuture.api.GreetingService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncConsumer {
    private static final byte SIGNAL = 1;

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/async-consumer.xml");
        context.start();
        GreetingService greetingService = context.getBean("greetingService", GreetingService.class);
        CompletableFuture<String> future = greetingService.greeting("async call request", SIGNAL);
        System.out.println("async call returned: " + future.get());
        System.out.println(greetingService.greeting("normal sync call request"));
    }

}
