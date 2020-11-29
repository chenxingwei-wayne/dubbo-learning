package org.apache.dubbo.dubbosamplesprovider.attachment.impl;

import org.apache.dubbo.dubbosamplesprovider.attachment.api.AttachmentService;
import org.apache.dubbo.rpc.RpcContext;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AttachementServiceImpl implements AttachmentService {

    @Override
    public String sayHello(String userName) {
        RpcContext context = RpcContext.getContext();
        String index = context.getAttachment("index");
        // 同一个context里面第二次调用就看不到这个值了。
        System.out.println("receive attachment index: " + index);
        System.out.println("[" + new SimpleDateFormat("HH:mm:ss").format(new Date()) + "] Hello " + userName +
                ", request from consumer: " + context.getRemoteAddress());
        return"Hello " + userName + ", response from provider: " + context.getLocalAddress() +
                ", attachment - index: " + index;
    }
}
