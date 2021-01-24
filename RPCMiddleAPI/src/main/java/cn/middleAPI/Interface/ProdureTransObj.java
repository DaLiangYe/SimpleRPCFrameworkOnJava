package cn.middleAPI.Interface;

import cn.middleAPI.CommonFrameWork.ClassPathMapped;
import cn.middleAPI.Objects.TransPortObj;
/*
* This interface "cn.middleAPI.Interface.ProdureTransObj" is a stand operation of
* "cn.middleAPI.Objects.TransPortObj".
*
* It is needed that "cn.middleAPI.Interface.ProdureTransObj" and "cn.middleAPI.Objects.TransPortObj"
* are required to defined and explored outside before designing and coding. */
@ClassPathMapped("cn.providerImple.imple.ProdureTransObjImple")
public interface ProdureTransObj{
    //factMethodOne is a method to remote procedure calling.
    public TransPortObj factMethodOne(TransPortObj paramObj);
}
