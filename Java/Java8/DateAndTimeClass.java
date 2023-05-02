package Java.Java8;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateAndTimeClass {
	public static void main(String args[]) {
		
		//Print Date using Java8
		LocalDate todayDate=LocalDate.now();
		LocalDate yesterdayDate=todayDate.minusDays(1);
		LocalDate tomorrowDate=todayDate.plusDays(1);
		
		System.out.println("Today's date is "+todayDate);
		System.out.println("Yesterday's date is "+yesterdayDate);
		System.out.println("Tomorrow's date is "+tomorrowDate);
		
		//check whether Date is in Leap Year or not
		System.out.println(todayDate.isLeapYear());
		
		//Print Date and Time using java8
		LocalDateTime dateTime=LocalDateTime.now();
		System.out.println("Today's Date & Time is "+dateTime);	
		
	}

}
