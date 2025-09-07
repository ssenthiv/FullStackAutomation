package collection;

public class ResultSet implements Comparable<ResultSet> {
	
	double precission=0;
	double recall=0;
	Double total;
	
		
			
		public ResultSet(){
		
		
		this.total=(double) 0;
		
	}
			
		public ResultSet(double p, double r){
		
		this.precission=p;
		this.recall=r;
		this.total=p+r;
		
	}
	
	public int compareTo(ResultSet o){
		
		Double total=this.total;
		Double ototal=o.total;
		return total.compareTo(o.total);
		
	}
	public boolean isEmpty(ResultSet r){
		
		if (r.total==0){
			return true;
		}else
			return false;
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		double p=5.4;
		double r=6.3;
		ResultSet result1 =new ResultSet(p,r);
		
		ResultSet result2 =new ResultSet(12.0,50.1);
		System.out.println(result1.total + " " +  result2.total);
		
	}

}
