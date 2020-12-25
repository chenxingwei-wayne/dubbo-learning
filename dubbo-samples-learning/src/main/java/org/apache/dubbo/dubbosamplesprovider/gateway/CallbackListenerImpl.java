package org.apache.dubbo.dubbosamplesprovider.gateway;

public class CallbackListenerImpl implements CallbackListener {
    @Override
    public void changed(String msg) {
        System.out.println("receive message from server :" + msg);
    }
}
