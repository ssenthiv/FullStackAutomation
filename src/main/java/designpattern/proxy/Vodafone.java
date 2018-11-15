package designpattern.proxy;

public class Vodafone implements ISP{

	public String getResource(String site){
		
		switch(site){
		
		case "www.google.com":
								return "GOOOOOOOOOOOOOOOGLE";
		case "www.yahoo.com":	
								return "YAHOOOOOOOOOOOOOOO";
		default	:
					return "Sorry No resourec found";
		}
	}
}
