package org.apache.dubbo.dubbosamplesprovider.callback;

import org.apache.dubbo.dubbosamplesprovider.callback.api.CallbackService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 这个例子就是为了在服务端调用客户端的代码逻辑
 */
public class CallbackConsumer {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/callback-consumer.xml");
        context.start();
        CallbackService callbackService = context.getBean("callbackService", CallbackService.class);

        callbackService.addListener("foo.bar", msg -> System.out.println("callback " + msg));
    }
}
