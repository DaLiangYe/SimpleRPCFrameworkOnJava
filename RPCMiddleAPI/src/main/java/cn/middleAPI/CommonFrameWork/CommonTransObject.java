package cn.middleAPI.CommonFrameWork;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/*
* This instance is contain the information of destination method to be called
* classPath, method name,instance list of arguments
* */
@Data
public class CommonTransObject implements Serializable {
    @Serial
    private static final long serialVersionUID = 4434177697815670358L;
    private String classPath;
    private String methodName;
    private Object[] args;
}