package org.apache.dubbo.dubbosamplesprovider.gateway;

import org.apache.dubbo.common.URL;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.cluster.loadbalance.RandomLoadBalance;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.List;

public class UserLoadBalance extends RandomLoadBalance {

    @Override
    public <T> Invoker<T> doSelect(List<Invoker<T>> invokers, URL url, Invocation invocation) throws RpcException {

        for (Invoker t : invokers) {
            try {
                InetAddress addr = InetAddress.getLocalHost();
                String ip = addr.getHostAddress().toString();
                URL u = t.getUrl();
                if (u.getIp().equals(ip)) {
                    return t;
                }
            } catch (UnknownHostException e) {
                e.printStackTrace();
            }
        }
        return super.doSelect(invokers, url, invocation);
    }
}
