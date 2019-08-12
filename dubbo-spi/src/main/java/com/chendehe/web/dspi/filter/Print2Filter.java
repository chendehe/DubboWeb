package com.chendehe.web.dspi.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.Filter;
import com.alibaba.dubbo.rpc.Invocation;
import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.Result;
import com.alibaba.dubbo.rpc.RpcException;

/**
 * @author CDH
 * @since 2019.8.12 012 10:38
 */
@Activate(value = {"filter2"}, group = {Constants.CONSUMER}, order = -11000)
public class Print2Filter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println(invoker.getUrl());
        return null;
    }
}
