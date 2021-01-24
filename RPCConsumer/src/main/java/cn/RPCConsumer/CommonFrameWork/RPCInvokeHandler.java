package cn.RPCConsumer.CommonFrameWork;

import cn.middleAPI.Objects.TransPortObj;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class RPCInvokeHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("1111");
        TransPortObj obj = new TransPortObj();
        obj.setTransName("sss");
        obj.setTransIdNo(123);
        obj.setReturnWords("hello");
        return null;
    }
}
