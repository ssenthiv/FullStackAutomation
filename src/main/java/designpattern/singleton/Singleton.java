package designpattern.singleton;

public class Singleton {
	
	private static Singleton _instance;
	//private static int staticInt=10;
	//private int instanceInt=20;
	private Singleton(){}
	
	//public static synchronized Singleton getInstance(){        // for thread safe
	public static  Singleton getInstance1(){					 // Not thread safe
		
		if (_instance == null)
			_instance=new Singleton();
		return _instance;
		
		
	}
	
	public static Singleton getInstance(){
		
		return SingletonHelper._innerInstance;
	}

	private static class SingletonHelper{
		private static Singleton _innerInstance=new Singleton();
	}
}
