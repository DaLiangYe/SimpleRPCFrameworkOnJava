package cn.RPCConsumer.CommonFrameWork;

import java.io.Serializable;
import java.lang.reflect.Proxy;

public class ProxyFactory {

    public static <T> T getInstanceByClassType(Class<T> interfaceClass){
        return (T)Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),new Class[]{interfaceClass, Serializable.class},new RPCInvokeHandler());
    }
}
