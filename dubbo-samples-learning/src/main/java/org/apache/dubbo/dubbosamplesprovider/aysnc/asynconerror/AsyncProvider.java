package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class AsyncProvider {
    public static void main(String[] args) throws IOException {
        new EmbeddedZooKeeper(2181, false).start();
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"spring/async-provider.xml"});
        context.start();
        System.in.read();
    }
}
