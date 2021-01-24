package cn.providerImple.imple;
import cn.middleAPI.Interface.ProdureTransObj;
import cn.middleAPI.Objects.TransPortObj;
import java.util.Random;

/*
* provider must implements the interface to provide service for caller*/
public class ProdureTransObjImple implements ProdureTransObj{
    @Override
    public TransPortObj factMethodOne(TransPortObj transPortObj) {
        System.out.println("the provider produre begin");
        transPortObj.setTransName("ChangedName");
        transPortObj.setTransIdNo(new Random().nextInt(100));
        transPortObj.setReturnWords("Provider have produre success");
        System.out.println("the provider produre end");
        return transPortObj;
    }
}
