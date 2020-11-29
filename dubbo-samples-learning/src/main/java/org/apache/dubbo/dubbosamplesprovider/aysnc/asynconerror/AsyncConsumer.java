package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror;

import org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class AsyncConsumer {
    public static void main(String[] args) throws ExecutionException, InterruptedException, IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/async-consumer.xml"});
        context.start();
        final AsyncService asyncService = (AsyncService) context.getBean("asyncService");

       /* asyncService.sayHello("world");
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        helloFuture.whenComplete((retValue, exception) -> {
            if (exception == null) {
                System.out.println(retValue);
            } else {
                exception.printStackTrace();
            }
        });*/
        // 客户端调用服务端超时，默认重试了三次，但是还是失败了，第三次失败了抛出异常。失败之后的filter返回结果的顺序跟filter的配置顺序相反。
        asyncService.sayHelloTimeout("timeout world");
        CompletableFuture<String> helloFuture = RpcContext.getContext().getCompletableFuture();
        helloFuture.get();

        System.in.read();
    }
}
