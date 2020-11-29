package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture;

import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class AsyncConsumer {
    private static Logger logger = LoggerFactory.getLogger(AsyncConsumer.class);

    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/async-consumer.xml");
        context.start();
        AsyncService asyncService = context.getBean("asyncService", AsyncService.class);
        RpcContext.getContext().setAttachment("consumer-key1", "consumer-value1");

        CompletableFuture<String> future = asyncService.sayHello("async call request");
        RpcContext savedServerContext = RpcContext.getServerContext();
        CountDownLatch latch = new CountDownLatch(1);
        // 请求结束了，context中的内容也丢失了。所以获取的为null，看官方解释是：通过上下文存放当前调用过程中所需的环境信息。
        // 所以调用过程一结束其中的信息自然也就丢失了。
        System.out.println("1111" + (String)savedServerContext.getAttachment("server-key1"));
        future.whenComplete((v, t) -> {
            // 请求结束了，context中的内容也丢失了。所以获取的为null
            System.out.println("1111" + (String)savedServerContext.getAttachment("server-key1"));
            System.out.println("1111filters" + (String)savedServerContext.getAttachment("filters"));
            if (t != null) {
                logger.info("Exception: ", t);
            } else {
                logger.info("Response: " + v);
            }
//            latch.countDown();
        });
        logger.info("Executed before response returns");
        latch.await();
    }
}
