package designpattern.proxy;

import java.util.Calendar;

public class InternetProxy implements ISP{
	
	private void logRequest(String site){
		System.out.println(Calendar.getInstance().getTime()+ "requested for site - "+site);
	}
	private boolean isBlocked(String site){
		
		switch(site){
		
		case "www.google.com" :
								return false;
		case "www.gaming.com" :
								return true;
		case "www.youtube.com" : 
								return false;
		default :	
								return true;
									
		}
	}


	public  String getResource(String site){
		this.logRequest(site);
		if (this.isBlocked(site))
			return "This site is blocked as per the company policy";
		
		NetworkSettings ns= new NetworkSettings();
		return ns.getISP().getResource(site);
		
		
	}

}
