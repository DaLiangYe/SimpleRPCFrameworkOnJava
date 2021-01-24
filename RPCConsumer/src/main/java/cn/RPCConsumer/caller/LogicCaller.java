package cn.RPCConsumer.caller;
import cn.RPCConsumer.CommonFrameWork.ProxyFactory;
import cn.middleAPI.Interface.ProdureTransObj;
import cn.middleAPI.Objects.TransPortObj;

/*
* the aim of this main method is to simulate the really logical calling*/
public class LogicCaller {
    public static void main(String[] args){
        ProdureTransObj instance = ProxyFactory.getInstanceByClassType(ProdureTransObj.class);
        TransPortObj obj = new TransPortObj();
        obj.setTransName("ttt");
        obj.setTransIdNo(456);
        obj.setReturnWords("...");
        System.out.println("call before:"+obj);
        obj = instance.factMethodOne(obj);
        System.out.println("call after:"+obj);
    }
}
