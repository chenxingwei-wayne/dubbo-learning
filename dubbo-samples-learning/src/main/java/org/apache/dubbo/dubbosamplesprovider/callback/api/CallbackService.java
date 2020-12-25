package org.apache.dubbo.dubbosamplesprovider.callback.api;

public interface CallbackService {
    void addListener(String key, CallbackListener callbackListener);
}
