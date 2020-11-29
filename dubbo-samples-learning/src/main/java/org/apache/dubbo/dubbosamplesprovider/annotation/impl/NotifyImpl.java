package org.apache.dubbo.dubbosamplesprovider.annotation.impl;

import org.apache.dubbo.dubbosamplesprovider.annotation.api.Notify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotifyImpl implements Notify {
    private List<String> invokes = new ArrayList<>();
    private Map<String, String> returns = new HashMap<>();
    private Map<String, Throwable> exceptions = new HashMap<>();

    @Override
    public void onInvoke(String request) {
        System.out.println("onInvoke request: " + request);
        invokes.add(request);
    }

    @Override
    public void onReturn(String response, String request) {
        System.out.println("onReturn - req " + request + "res: " + response);
        returns.put(request, response);
    }

    @Override
    public void onThrow(Throwable ex, String request) {
        System.out.println("onThrow - request: " + request + ", exception: " + ex);
        exceptions.put(request, ex);
    }

    @Override
    public List<String> getInvokes() {
        return invokes;
    }

    @Override
    public Map<String, String> getReturns() {
        return returns;
    }

    @Override
    public Map<String, Throwable> getExceptions() {
        return exceptions;
    }
}
