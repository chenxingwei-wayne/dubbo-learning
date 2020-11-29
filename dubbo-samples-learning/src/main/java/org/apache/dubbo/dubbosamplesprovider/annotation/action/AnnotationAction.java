package org.apache.dubbo.dubbosamplesprovider.annotation.action;

import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.dubbosamplesprovider.annotation.AnnotationConstants;
import org.apache.dubbo.dubbosamplesprovider.annotation.api.GreetingService;
import org.apache.dubbo.dubbosamplesprovider.annotation.api.HelloService;
import org.springframework.stereotype.Component;

@Component("annotationAction")
public class AnnotationAction {
    @Reference(interfaceClass = HelloService.class, version = AnnotationConstants.VERSION)
    private HelloService helloService;

    // 这里再客户端设置了1秒的超时，
    @Reference(interfaceClass = GreetingService.class, version = AnnotationConstants.VERSION, timeout = 1000, methods = {
            @Method(name="greeting", timeout = 3000, retries = 1)
    })
    private GreetingService greetingService;

    public String doSayHello(String name) {
        try {
            return helloService.sayHello(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String doSayGoodbye(String name) {
        try {
            return helloService.sayGoodbye(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String doGreeting(String name) {
        try {
            return greetingService.greeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }

    public String replyGreeting(String name) {
        try {
            return greetingService.replyGreeting(name);
        } catch (Exception e) {
            e.printStackTrace();
            return "Throw Exception";
        }
    }
}
