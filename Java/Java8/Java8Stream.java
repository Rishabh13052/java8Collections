package Java.Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Java8Stream {
	
	public static void main(String args[]){
		List<String> l1=Arrays.asList("1","3","4","2");
		
		//Sequential Stream
		System.out.println("Sequential Stream");
		l1.stream().forEach(System.out::println);
		
		//Parallel Stream
		System.out.println("Parallel Stream");
		l1.parallelStream().forEach(System.out::println);
		
		//Sort the data using sequential stream.
		System.out.println("Sort with Sequential Stream");
		l1.stream().sorted().forEach(System.out::println);
		
		//Sort the data using Parallel Stream.
		System.out.println("Sort with Sequential Stream");
		
		//For parallel stream, we have to use forEachOrdered Method to sort the data
		l1.parallelStream().sorted().forEachOrdered(System.out::println);
		
		//Sort the data in Descending order
		System.out.println("Sort with Sequential Stream in Descending order");
		l1.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
		
		System.out.println("Sort with Parallel Stream in Descending order");
		l1.parallelStream().sorted(Comparator.reverseOrder()).forEachOrdered(System.out::println);
		
		
		
		
		
		
	}

}
