package cn.RPCConsumer.CommonFrameWork;
import cn.RPCConsumer.netHelp.NetHelper;
import cn.middleAPI.CommonFrameWork.ClassPathMapped;
import cn.middleAPI.CommonFrameWork.CommonTransObject;
import cn.middleAPI.Objects.TransPortObj;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/*
* the common dynamic proxy method, it can get the needed information,
* such as: method name,instance list of arguments,the class whole classpath name.
* all above the information can make remote procedure successfully */
public class RPCInvokeHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //combine the CommonTransObject instance:
        CommonTransObject sendObj = new CommonTransObject();
        sendObj.setArgs(args);
        sendObj.setMethodName(method.getName());
        sendObj.setClassPath(method.getDeclaringClass().getAnnotation(ClassPathMapped.class).value());
        //send the sendObj instance to the socket pipe.
        Object obj = null;
        obj = NetHelper.remoateCall("localhost",9999,sendObj);
        return obj;
    }
}
