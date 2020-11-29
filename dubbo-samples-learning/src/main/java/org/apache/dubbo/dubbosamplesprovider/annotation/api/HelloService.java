package org.apache.dubbo.dubbosamplesprovider.annotation.api;

public interface HelloService {
    String sayHello(String name);

    default String sayGoodbye(String name) {
        return "Goodbye, " + name;
    }
}
