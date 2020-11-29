package org.apache.dubbo.dubbosamplesprovider.aysnc.asynconerror.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.*;
// 给provider以及consumer都使用filter，consumer如果设置了async=true，则这里取值为null，如果设置的是false
// ，则NormalSyncFilter跟NormalAsyncFilter都会走。
@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER}, order=9990)
public class NormalSyncFilter implements Filter {
    public NormalSyncFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        Result result = invoker.invoke(invocation);
        System.out.println("Normal sync filter, the value maybe null: " + result.getValue());
        return result;
    }
}
