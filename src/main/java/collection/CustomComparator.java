package collection;

import java.util.Comparator;

public class CustomComparator implements Comparator<Car> {

	@Override
	public int compare(Car o1, Car o2) {
		//System.out.println("Inside Comparator -----CAR");
			if  (o1.getPrice()== o2.getPrice()){
				return 0;
			
			}else if (o1.getPrice()% 2 == 1 ){
				if( o2.getPrice()% 2 == 0)
					return -1;
				else if (o1.getPrice() > o2.getPrice())
					return -1;
				else 
					return 1;
			}else if ( o2.getPrice()% 2 == 0){
				if (o1.getPrice() > o2.getPrice())
					return -1;
				else 
					return 1;
			}else
				return 1;
				
	}

}
