package coreJava;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class DecimalFormatExample {
	public static void main(String[] args ){
		
		double value1=112345.691;
		
		// 0 -> Digit
		// # -> Digit , Zero shows as absent
		// E -> Separates mantissa and exponent
		//DecimalFormat df=new DecimalFormat("00.0000");
		DecimalFormat df=new DecimalFormat("##.0E0");
		System.out.println("Value = " +df.format(value1));
		System.out.println("Double = " +Double.parseDouble(df.format(value1)));
		
		
	}

}
