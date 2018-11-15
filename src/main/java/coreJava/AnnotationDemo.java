package coreJava;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited
@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Smartphone{
	String os() default "Symbian";
	int version() default 1;
}

@Smartphone(os="Android", version=6)
class NokiaSeries{
	String model;
	int size;
	
	public NokiaSeries(String model, int size){
		
		this.model=model;
		this.size=size;
		
	}
	
}


public class AnnotationDemo {
	
	public static void main(String[] args){
		/*
		NokiaSeries obj=new NokiaSeries("Fire", 5);
		Class clazz=obj.getClass();
		Annotation an=clazz.getAnnotation(Smartphone.class);
		Smartphone sp=(Smartphone)an;
		*/
		Smartphone sp= new NokiaSeries("Fire", 5).getClass().getAnnotation(Smartphone.class);
		System.out.println(sp.os());
		System.out.println(sp.version());
	}

}
