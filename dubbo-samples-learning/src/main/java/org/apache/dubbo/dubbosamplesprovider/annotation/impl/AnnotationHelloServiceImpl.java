package org.apache.dubbo.dubbosamplesprovider.annotation.impl;

import org.apache.dubbo.config.annotation.Method;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.dubbosamplesprovider.annotation.AnnotationConstants;
import org.apache.dubbo.dubbosamplesprovider.annotation.api.HelloService;

// 服务端设置了250毫秒的超时，但是接口调用超过了250毫秒，所以会报错。可以把timeout时间延长再进行测试。
@Service(version = AnnotationConstants.VERSION, methods = {@Method(name = "sayGoodbye", timeout = 350, retries = 0)})
public class AnnotationHelloServiceImpl implements HelloService {
    @Override
    public String sayHello(String name) {
        System.out.println("Provider received invoke of sayHello: " + name);
        sleepWhile();
        return "Annotation, hello" + name;
    }

    @Override
    public String sayGoodbye(String name) {
        System.out.println("provider received invoke of sayGoodbye: " + name);
        sleepWhile();
        return "Goodbye, " + name;
    }

    private void sleepWhile() {
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
