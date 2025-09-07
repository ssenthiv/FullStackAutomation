package hackerrank.java;

public class FindLargestSmallestNumber {

	public static void main(String[] args) {
		
		
		int[] number=new int[]{36,10_5,-2_0,20_0,3,40};
		int largest=number[0];
		int smallest=number[0];
		for(int i=1;i<number.length;i++){
			
			if (number[i] > largest){
				
			largest=number[i];	
			}else if (number[i] < smallest){
			smallest=number[i];
			}
			
		}
		System.out.println("Largest number is "+ largest);
		System.out.println("Smallest number is "+ smallest);
		
	}
	
}
