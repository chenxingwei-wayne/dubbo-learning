package org.apache.dubbo.dubbosamplesprovider.annotation.api;

import java.util.List;
import java.util.Map;

public interface Notify {
    void onInvoke(String request);

    void onReturn(String response, String request);

    void onThrow(Throwable ex, String request);

    List<String> getInvokes();

    Map<String, String> getReturns();

    Map<String, Throwable> getExceptions();
}
