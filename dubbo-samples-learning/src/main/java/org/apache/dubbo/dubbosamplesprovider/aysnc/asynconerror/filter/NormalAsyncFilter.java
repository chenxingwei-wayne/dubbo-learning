package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order=9991)
public class NormalAsyncFilter implements Filter, Filter.Listener {
    public NormalAsyncFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        System.out.println("normal async received result: " + appResponse.getValue());
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        System.out.println("NormalAsyncFilter onError executed: " + t.getMessage());
    }
}
