package Java8;

import java.util.function.BiConsumer;

public class ExceptionHandling {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args){
		
		int[] someNumbers={1,2,3,4,5};
		int key=0;
		
		System.out.println("1.without wrapper Addition");
		operation(someNumbers,key,(v,k)-> {
			try{
			System.out.print(v/k+ " ");
			}catch(Exception e){
				System.out.println("Some exception");
			}
		});
		System.out.println("\n2.with wrapper Division");
		operation(someNumbers,key,wrapperOperation((a,b)->System.out.print(a/b +" ")));
		
		
	}

	 
	public static void operation(int[] numbers , int key,BiConsumer<Integer,Integer> consumer ){
		
		for(int value :numbers)
		
			consumer.accept(value, key);
	}
	
	public static BiConsumer<Integer,Integer> wrapperOperation(BiConsumer<Integer,Integer> consumer ){
		
		return (a,b)->{
			try {
				consumer.accept(a, b);
			} catch (ArithmeticException e) {
				System.out.println("ArithMatic Exception");
			}

		};
		
	
		
	}
	
	
		
	
	
}
