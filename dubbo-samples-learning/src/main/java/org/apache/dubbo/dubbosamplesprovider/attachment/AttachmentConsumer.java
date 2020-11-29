package org.apache.dubbo.dubbosamplesprovider.attachment;

import org.apache.dubbo.dubbosamplesprovider.attachment.api.AttachmentService;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AttachmentConsumer {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring/attachment-consumer.xml");
        context.start();
        AttachmentService attachmentService = context.getBean("attachmentService", AttachmentService.class);
        RpcContext.getContext().setAttachment("index", "1111");
        String hello = attachmentService.sayHello("world");
        System.out.println(hello);
        hello = attachmentService.sayHello("world");
        System.out.println(hello);
    }
}
