package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order=9998)
public class OnResponseThrowableFilter implements Filter, Filter.Listener {

    public OnResponseThrowableFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        System.out.println("onResponse received value : " + appResponse.getValue());
        if (null != invocation) {
            throw new RuntimeException("Exception from onResponse.");
        }
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        System.out.println("onResponseThrowableAsyncFilter onError executed: " + t.getMessage());
    }
}
