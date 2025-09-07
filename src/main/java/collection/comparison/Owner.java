package collection.comparison;

import java.util.Random;

public class Owner implements Comparable<Owner> {
//public class Owner {
	private String ownerName;
	
	public Owner(String name){
		this.ownerName=name;
	}
	
	public Owner(){
		final String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		int N=alphabet.length();
		Random r=new Random();
		StringBuffer name=new StringBuffer();
		
		for(int i=0; i<6;i++){
			name.append(alphabet.charAt(r.nextInt(N)));
			
		}
		this.ownerName=name.toString();
	}
	

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String toString(){
		
		return ownerName;
	}
	
	public boolean equals(Object o){
		System.out.println("inside equals------------Owner");	
		if (o != null && o instanceof Owner){
		String	 name=((Owner) o).getOwnerName();
		if (name.equals(this.getOwnerName()))
			return true;
		}
		
		return false;
	}
	
	public int hashCode(){
		System.out.println("inside hashCode------------Owner");	
	return this.ownerName.hashCode();
	}

	@Override
	public int compareTo(Owner obj){
		System.out.println("inside compareTo------------Owner");
			
		return this.ownerName.compareTo(obj.ownerName);

	}

}
