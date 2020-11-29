package org.apache.dubbo.dubbosamplesprovider.annotation.impl;

import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.dubbosamplesprovider.annotation.AnnotationConstants;
import org.apache.dubbo.dubbosamplesprovider.annotation.api.GreetingService;

@Service(version = AnnotationConstants.VERSION)
public class AnnotationGreetingServiceImp implements GreetingService {
    @Override
    public String greeting(String name) {
        System.out.println("Provider received invoke of greeting: " + name);
        sleepWhile();
        return "Annotation, greeting " + name;
    }

    // 因为reply耗时超过1000，所以服务端会报超时。
    @Override
    public String replyGreeting(String name) {
        System.out.println("Provider received invoke of replyGreeting: " + name);
        sleepWhile();
        return "Annotation, fine " + name;
    }

    private void sleepWhile() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
