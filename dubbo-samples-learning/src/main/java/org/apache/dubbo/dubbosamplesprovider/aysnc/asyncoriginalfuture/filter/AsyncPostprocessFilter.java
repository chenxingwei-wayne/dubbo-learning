package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.CONSUMER, CommonConstants.PROVIDER})
public class AsyncPostprocessFilter implements Filter, Filter.Listener {

    private static Logger logger = LoggerFactory.getLogger(AsyncPostprocessFilter.class);

    public AsyncPostprocessFilter() {
    }

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        String filters = context.getAttachment("filters");
        if (StringUtils.isEmpty(filters)) {
            filters = "";
        }
        filters += " async-post-process-filter";
        context.setAttachment("filters", filters);
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        logger.info("filter get the value: " + appResponse.getValue());
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
        logger.error("filter get error", t);
    }
}
