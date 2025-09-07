package collection;

import java.util.Map;
import java.util.Properties;
import java.util.Set;

public class SystemProperties {

	public static  void main(String args[]){
	
		
		//Properties props = System.getProperties();
		Set<Object> oset = System.getProperties().keySet();
		Map<String,String> map =System.getenv();
		
		for (Object pro :  oset ){
			
			System.out.println(pro.toString() + " : "+System.getProperty(pro.toString()));
		}
		
		for (Map.Entry<String, String> entry :  map.entrySet() ){
			
			System.out.println(entry.getKey()+":"+ entry.getValue());
		}
		System.out.println(System.getProperty("user.dir"));
	}
	
}
