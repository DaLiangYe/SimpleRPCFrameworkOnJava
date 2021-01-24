package cn.providerImple;
import cn.middleAPI.CommonFrameWork.CommonTransObject;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
* This class will reflects the destination class to dispatch service */
public class ServiceDispatcher {
    public static Object dispatch(Object paramObj){
        //resolution the destination class, method, list of arguments.
        //new a destination instance and caller its method later.
        //return the result of procedure lastly.
        CommonTransObject reciveObj = (CommonTransObject)paramObj;
        String classPath = reciveObj.getClassPath();
        String methodName = reciveObj.getMethodName();
        Object[] argsList = reciveObj.getArgs();
        //use the reflection of java to new the instance of destination class.
        Class[] listTypeOfParams = null;
        if(argsList != null){
            int len = argsList.length;
            for (int i = 0; i < len; i++) {
                listTypeOfParams[i] = argsList[i].getClass();
            }
        }
        Class<?> clazz = null;
        Method method = null;
        Object outputObject = null;
        try {
            clazz = Class.forName(classPath);
            method = clazz.getDeclaredMethod(methodName,listTypeOfParams);
            outputObject =  method.invoke(clazz.newInstance(),argsList);//caller the suitable method
        } catch (ClassNotFoundException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        //return the result
        return outputObject;
    }
}
