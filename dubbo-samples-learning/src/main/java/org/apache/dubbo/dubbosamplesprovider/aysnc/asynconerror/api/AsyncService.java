package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.api;

public interface AsyncService {
    String sayHello(String name);
    String sayHelloTimeout(String name);
}
