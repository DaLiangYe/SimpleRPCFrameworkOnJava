package cn.middleAPI.CommonFrameWork;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/*
* This Annotation can let coder to save the full classpath.
* we don`t need to hard code the full classpath in the logical code.*/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ClassPathMapped {

    String value();
}