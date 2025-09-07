package coreJava;

//declare an interface
interface IntExample extends IntExample3 {
 
  /*
  Syntax to declare method in java interface is,
 <modifier> <return-type> methodName(<optional-parameters>);
  IMPORTANT : Methods declared in the interface are implicitly public and abstract.
  */
  
  public void sayHello();
  }


interface IntExample2  {
 
	  public void sayHello2();
	  }

interface IntExample3 extends IntExample4{
	 
	  public void sayHello3();
	  }

interface IntExample4{
	 
	  public void sayHello4();
	  }
/*
25.Classes are extended while interfaces are implemented.
26.To implement an interface use implements keyword.
27.IMPORTANT : A class can extend only one other class, while it 
28.can implement n number of interfaces.
29.*/
 
public class JavaInterfaceExample implements IntExample,IntExample2 {
 /*
33.  We have to define the method declared in implemented interface,
34.  or else we have to declare the implementing class as abstract class.
35.  */
  
  public void sayHello(){
   System.out.println("Hello Visitor !");
  }
  public void sayHello2(){
	   System.out.println("Hello Visitor 2 !");
	  }
  public void sayHello3(){
	   System.out.println("Hello Visitor 3 !");
	  }
  public void sayHello4(){
	   System.out.println("Hello Visitor 4 !");
	  }
  public static void main(String args[]){
    //create object of the class
    JavaInterfaceExample javaInterfaceExample = new JavaInterfaceExample();
    //invoke sayHello(), declared in IntExample interface.
    javaInterfaceExample.sayHello();
    javaInterfaceExample.sayHello2();
    javaInterfaceExample.sayHello3();
    javaInterfaceExample.sayHello4();
  }
}
 
/*
50.OUTPUT of the above given Java Interface example would be :
51.Hello Visitor !
52.*/


