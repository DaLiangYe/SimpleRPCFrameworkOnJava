package cn.RPCConsumer.CommonFrameWork;

import java.io.Serializable;
import java.lang.reflect.Proxy;

/*
* The aim of the static method is to come back dynamic proxy instance which
* can send message to another JVM and get the return message Object */
public class ProxyFactory {

    public static <T> T getInstanceByClassType(Class<T> interfaceClass){
        return (T)Proxy.newProxyInstance(ProxyFactory.class.getClassLoader(),new Class[]{interfaceClass, Serializable.class},new RPCInvokeHandler());
    }
}
