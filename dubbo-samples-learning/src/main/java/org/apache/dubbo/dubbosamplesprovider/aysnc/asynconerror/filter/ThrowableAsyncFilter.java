package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order=10000)
public class ThrowableAsyncFilter implements Filter, Filter.Listener {
    public ThrowableAsyncFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        if (invocation != null) {
            throw new RuntimeException("exception before invoke()");
        }
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {

    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        System.out.println("ThrowableAsyncFilter on Error executed: " + t.getMessage());
    }
}
