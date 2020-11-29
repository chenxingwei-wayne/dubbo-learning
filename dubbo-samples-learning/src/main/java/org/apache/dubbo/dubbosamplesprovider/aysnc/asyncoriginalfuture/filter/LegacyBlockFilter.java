package org.apache.dubbo.dubbosamplesprovider.aysnc.asyncoriginalfuture.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.common.logger.Logger;
import org.apache.dubbo.common.logger.LoggerFactory;
import org.apache.dubbo.common.utils.StringUtils;
import org.apache.dubbo.rpc.*;

@Activate(group = {CommonConstants.PROVIDER, CommonConstants.CONSUMER})
public class LegacyBlockFilter implements Filter {
    private static Logger logger = LoggerFactory.getLogger(LegacyBlockFilter.class);

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        RpcContext context = RpcContext.getContext();
        String filters = context.getAttachment("filters");
        if (StringUtils.isEmpty(filters)) {
            filters = "";
        }
        filters += " legacy-block-filter";
        context.setAttachment("filters", filters);
        Result result = invoker.invoke(invocation);
        logger.info("This is the default return value: " + result.getValue());
        if (result.hasException()) {
            System.out.println("LegacyBlockFilter: This will only happen when the real exception returns: " + result.getException());
            logger.warn("This will only happen when the real exception returns", result.getException());
        }
        logger.info("LegacyBlockFilter: This msg should not be blocked.");
        return result;
    }
}
