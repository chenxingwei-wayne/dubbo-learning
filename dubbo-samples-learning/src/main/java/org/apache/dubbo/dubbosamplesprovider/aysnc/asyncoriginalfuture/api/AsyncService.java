package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture.api;

import java.util.concurrent.CompletableFuture;

public interface AsyncService {
    CompletableFuture<String> sayHello(String name);
}
