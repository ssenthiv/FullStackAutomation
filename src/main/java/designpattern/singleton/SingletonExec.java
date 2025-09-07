package designpattern.singleton;

public class SingletonExec {

	public static void main(String[] args) {
		
	
		for (int i=0; i< 5; i++){
			Singleton s=Singleton.getInstance();
			System.out.println(s.hashCode());
		}
	
		
		
		//System.out.println(Singleton.getInstance().hashCode());
		//System.out.println(Singleton.getInstance().hashCode());
	}

}
