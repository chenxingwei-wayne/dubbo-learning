package org.apache.dubbo.dubbosamplesprovider.callback.impl;

import org.apache.dubbo.dubbosamplesprovider.callback.api.CallbackListener;
import org.apache.dubbo.dubbosamplesprovider.callback.api.CallbackService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class CallbackServiceImpl implements CallbackService {

    public final Map<String, CallbackListener> listeners = new HashMap<>();

    public CallbackServiceImpl() {
        Thread t = new Thread(() -> {
            while (true) {
                try {
                    for (Map.Entry<String, CallbackListener> entry : listeners.entrySet()) {
                        try {
                            entry.getValue().changed(getChanged(entry.getKey()));
                        } catch (Throwable t1) {
                            listeners.remove(entry.getKey());
                        }
                    }
                    Thread.sleep(5000); // timely trigger change event
                } catch (Throwable t2) {
                    t2.printStackTrace();
                }
            }
        });
        t.setDaemon(true);
        t.start();
    }

    private String getChanged(String key) {
        return "Changed: " + new SimpleDateFormat("yy-MM-dd HH:mm:ss").format(new Date());
    }

    @Override
    public void addListener(String key, CallbackListener callbackListener) {
        listeners.put(key, callbackListener);
        callbackListener.changed(getChanged(key));
    }
}
