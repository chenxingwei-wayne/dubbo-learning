package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture.impl;

import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture.api.AsyncService;
import org.apache.dubbo.rpc.RpcContext;

import java.util.concurrent.CompletableFuture;

public class AsyncServiceImpl implements AsyncService {
    private static Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    @Override
    public CompletableFuture<String> sayHello(String name) {

        RpcContext savedContext = RpcContext.getContext();
        RpcContext savedServerContext = RpcContext.getServerContext();
        return CompletableFuture.supplyAsync(() -> {
            String received = savedContext.getAttachment("consumer-key1");
            logger.info("consumer-key1 from attachment: " + received);
            savedServerContext.setAttachment("server-key1", "server-" + received);

            received = savedContext.getAttachment("filters");
            logger.info("filters from attachment: " + received);
            savedServerContext.setAttachment("filters", received);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "async response from provider";
        });
    }
}
