package FrameWorks;

public class Testcase1Page extends Base{
	String methodName;
	void step1(){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();	
		Add_Log.info("\tExecuting - "+  this.getClass().getSimpleName()+"."+methodName );
	}
	void step2(){
		methodName=Thread.currentThread().getStackTrace()[1].getMethodName();	
		Add_Log.info("\tExecuting - "+  this.getClass().getSimpleName()+"."+methodName );
		//reportFailures("step2 failed");
		
	}

}
