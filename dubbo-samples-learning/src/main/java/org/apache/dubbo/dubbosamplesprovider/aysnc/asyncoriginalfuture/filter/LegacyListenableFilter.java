package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.CONSUMER, CommonConstants.PROVIDER})
public class LegacyListenableFilter extends ListenableFilter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        String filters = context.getAttachment("filters");
        if (StringUtils.isEmpty(filters)) {
            filters = "";
        }
        filters += "legacy-block-filter";
        context.setAttachment("filters", filters);
        return invoker.invoke(invocation);
    }

    private static class CallbackListener implements Filter.Listener {
        @Override
        public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
            System.out.println("Callback received in ListenableFilter.Response");
        }

        @Override
        public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {

        }
    }
}
