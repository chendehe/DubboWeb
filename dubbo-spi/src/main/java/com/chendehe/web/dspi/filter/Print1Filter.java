package com.chendehe.web.dspi.filter;

import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;

/**
 * @author CDH
 * @since 2019.8.12 012 10:38
 */
@Activate(value = {"filter2"}, group = {CommonConstants.PROVIDER}, order = -11000)
public class Print1Filter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        System.out.println(invoker.getUrl());
        return null;
    }
}
