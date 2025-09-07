package coreJava;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Inherited							// applicable for subclass
@Documented
@Target(ElementType.TYPE)			//Meta anotations
@Retention(RetentionPolicy.RUNTIME)	//Meta anotations
@interface Smartphone{
	String os() default "Symbian";
	int version() default 1;
}

@Smartphone(os="Android", version=15)
class SamsungSeries{
	String model;
	int size;
	
	public SamsungSeries(String model, int size){
		
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
		Smartphone sp= new SamsungSeries("Galaxy23", 6).getClass().getAnnotation(Smartphone.class);
		System.out.println(sp.os());
		System.out.println(sp.version());
	}

}
