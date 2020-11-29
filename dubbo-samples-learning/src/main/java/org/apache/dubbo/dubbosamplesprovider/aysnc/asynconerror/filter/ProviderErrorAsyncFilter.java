package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order=9999)
public class ProviderErrorAsyncFilter implements Filter, Filter.Listener {
    public ProviderErrorAsyncFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {

    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        System.out.println("ProviderErrorAsyncFilter onError executed: " + t.getMessage());
    }
}
