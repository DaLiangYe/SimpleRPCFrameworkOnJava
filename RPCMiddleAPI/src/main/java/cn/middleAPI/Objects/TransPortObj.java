package cn.middleAPI.Objects;

import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/*
* Due to the object of this class will be send to the another JVM platform by network.
* It is needed to implements Serializable interface  */
@Data
public class TransPortObj implements Serializable {
    @Serial
    private static final long serialVersionUID = 3999316630041405162L;
    String transName;
    int transIdNo;
    String returnWords;
}
