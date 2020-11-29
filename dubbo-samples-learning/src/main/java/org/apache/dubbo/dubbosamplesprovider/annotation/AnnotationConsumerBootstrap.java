package org.apache.dubbo.dubbosamplesprovider.annotation;

import org.apache.dubbo.dubbosamplesprovider.annotation.action.AnnotationAction;
import org.apache.dubbo.dubbosamplesprovider.annotation.config.ConsumerConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AnnotationConsumerBootstrap {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConsumerConfiguration.class);
        context.start();
        final AnnotationAction annotationAction = (AnnotationAction) context.getBean("annotationAction");
        System.out.println("hello: " + annotationAction.doSayHello("world"));
        System.out.println("goodbye: " + annotationAction.doSayGoodbye("world"));
        System.out.println("greeting: " + annotationAction.doGreeting("world"));
        System.out.println("reply: " + annotationAction.replyGreeting("world"));
    }
}
