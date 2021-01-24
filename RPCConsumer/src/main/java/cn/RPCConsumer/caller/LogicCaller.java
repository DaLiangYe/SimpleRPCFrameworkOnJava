package cn.RPCConsumer.caller;
import cn.RPCConsumer.CommonFrameWork.ProxyFactory;
import cn.middleAPI.Interface.ProdureTransObj;
import cn.middleAPI.Objects.TransPortObj;

public class LogicCaller {
    public static void main(String[] args){
        ProdureTransObj instance = ProxyFactory.getInstanceByClassType(ProdureTransObj.class);
        TransPortObj obj = new TransPortObj();
        obj.setTransName("ttt");
        obj.setTransIdNo(456);
        obj.setReturnWords("...");
        System.out.println(obj);
        obj = instance.factMethodOne(obj);
        System.out.println(obj);
    }
}
