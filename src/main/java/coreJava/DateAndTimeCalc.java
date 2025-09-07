package coreJava;

import java.text.DecimalFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.temporal.ChronoUnit;

public class DateAndTimeCalc {
	
	public static void main(String[] args){
		
		LocalDateTime date1=LocalDateTime.now();
		 date1=LocalDateTime.of(1977,02,26,0,0);
		
		try {
			Thread.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		LocalDateTime date2=LocalDateTime.now();
		
		
		
		// ChronoUnit
		// LocalDateTime
		System.out.println("1. Using ChronoUnits");
		
		long diffYear=ChronoUnit.YEARS.between(date1, date2);
		long diffDay=ChronoUnit.DAYS.between(date1, date2);
		long diffMon=ChronoUnit.MONTHS.between(date1, date2);
		long diffSec=ChronoUnit.SECONDS.between(date1, date2);
		long diffMill=ChronoUnit.MILLIS.between(date1, date2);
		long diffNano=ChronoUnit.NANOS.between(date1, date2);
		
		
		
		System.out.println("Date "+ date1 );
		
		System.out.println("Diff Years : "+ diffYear );
		System.out.println("Diff Months : "+ diffMon );
		System.out.println("Diff Days : "+ diffDay );
		System.out.println("Diff Seconds : "+ diffSec );
		System.out.println("Diff Millis : "+ diffMill );
		System.out.println("Diff Nano : "+ diffNano );
		
		
		// Periods between using LocalDateTime
		// Custom
		System.out.println("\n\n2. Using Custom calculation");
		
		DecimalFormat df=new DecimalFormat("#0.##");
		long remSeoncds=  diffSec ;
		remSeoncds=diffSec;
		
		long s = remSeoncds % 60 ;
		
		long m = (remSeoncds /60) % 60 ;
		long h= (remSeoncds / (60*60)) % 24 ;
		//double d= (remSeoncds / (60*60*24)) % 30.5 ;
		long months= diffMon - (diffYear * 12);
		double d = diffDay - (diffYear * 365.238) - (months*30.5);
		System.out.printf("\nRemainng Years  = "+ diffYear );
		System.out.printf("\nRemainng Months = " + df.format(months));
		System.out.printf("\nRemainng Days 	= " + df.format(d));	
		System.out.printf("\nRemainng Time 	= " + df.format(h) +  " : " +df.format(m) +  " : " + df.format(s) );
		
		
		// Period.between 
		// LocalDate
		System.out.println("\n\n3. Using Period class");
		LocalDate ldate1=LocalDate.of(1977, 2, 26);
		LocalDate ldate2=LocalDate.now();
		
		Period period=Period.between(ldate1, ldate2);
		System.out.println("\n\nyears 	: "+ period.getYears());
		System.out.println("Months 	: "+ period.getMonths());
		System.out.println("Days 	: "+ period.getDays());
		
		
		// Duration.between
		System.out.println("\n\n4. Using Duration class");
		
		Duration duration = Duration.between(date1, date2);
		int years =(int) (duration.toDays()/365.238);
		System.out.println("Years  : " +years);
		int month =(int) (duration.toDays()%365.238 /30.5);
		System.out.println("Months : " +month);
		int day =(int) (duration.toDays()%365.238 %30.5);
		System.out.println("Days   : "+day);
		int hour =(int) (duration.toHours()  % 24);
		System.out.println("Hours  : "+hour);
		int min =(int) (duration.toMinutes()  % 60);
		System.out.println("Minutes: "+min);
		int sec =(int) (duration.toSeconds()  % 60);
		System.out.println("Seconds: "+sec);
	}

}
