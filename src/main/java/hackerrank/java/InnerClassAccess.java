package hackerrank.java;

import java.io.*;
import java.lang.reflect.*;
import java.util.*;
import java.util.regex.*;
import java.security.*;


public class InnerClassAccess {

	public static void main(String[] args) throws Exception {
		DoNotTerminate.forbidExit();	

		try{
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int num = Integer.parseInt(br.readLine().trim());
			Object o;// Must be used to hold the reference of the instance of the class Solution.Inner.Private
			/*//pubic inner class
			InnerClassAccess ia=new InnerClassAccess();
			Inner inner=ia.new Inner();
			
			Class<?> pClass=Inner.class.getDeclaredClasses()[0];
			Constructor<?> cons=pClass.getDeclaredConstructors()[0];
			cons.setAccessible(true);
			Object p=	cons.newInstance(inner);
			
			Method method=p.getClass().getDeclaredMethod("powerof2", int.class);
			method.setAccessible(true);
			o=p;
			System.out.println(method.invoke(p,num).toString());
			*/
			
			// Static Inner Class
			
			Constructor<?> cons = Inner.Private.class.getDeclaredConstructors()[0];
			cons.setAccessible(true);
			//Inner inner =Inner.class.newInstance();
			InnerClassAccess.Inner inner=new InnerClassAccess.Inner();
			Object p =cons.newInstance(inner);
				
			Method method=p.getClass().getDeclaredMethod("powerof2", int.class);
			method.setAccessible(true);
			
			System.out.println(method.invoke(p,num).toString());
			o=p;
			//Class<?> c=Class.forName("Private");
			
		System.out.println("An instance of class: " + o.getClass().getCanonicalName() + " has been created");
		
		}//end of try
		
		catch (DoNotTerminate.ExitTrappedException e) {
			System.out.println("Unsuccessful Termination!!");
		}
	}//end of main
	
	
	 static   class Inner{
	 
		 class Private{
			
			private String powerof2(int num){
				return ((num&num-1)==0)?"power of 2":"not a power of 2";
			}
		}
	}//end of Inner
	
}//end of Solution
/*
static class Inner{
 private class Private{
	
	private String powerof2(int num){
		return ((num&num-1)==0)?"power of 2":"not a power of 2";
	}
}
}
*/
class DoNotTerminate { //This class prevents exit(0)
	 
    public static class ExitTrappedException extends SecurityException {

		private static final long serialVersionUID = 1L;
    }
 
    public static void forbidExit() {
        final SecurityManager securityManager = new SecurityManager() {
            @Override
            public void checkPermission(Permission permission) {
                if (permission.getName().contains("exitVM")) {
                    throw new ExitTrappedException();
                }
            }
        };
        System.setSecurityManager(securityManager);
    }
}	
	