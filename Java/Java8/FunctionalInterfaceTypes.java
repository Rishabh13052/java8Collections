package Java.Java8;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class FunctionalInterfaceTypes {
	public static void main(String args[]) {
		
		//Function Functional Interface
		System.out.println("Below is the output for Function FI");
		//Get the length of string
		Function<String, Integer> getLength=x->x.length();
		int length=getLength.apply("Rishabh");
		System.out.println("Length is "+length);
		
		//Change String to UpperCase
		Function<String, String> changeUpperCase=x->x.toUpperCase();
		String str=changeUpperCase.apply("Rishabh");
		System.out.println("UpperCase is "+str);
		
		
		//Predicate Functional Interface
		System.out.println("Below is the output for Predicate FI");
		//Get the String which starts from G
		List<String> list=Arrays.asList("Gyan","Gaurav","Amit","Gun1","Rishabh","gdfg");
		Predicate<String> printStringStartWithG=(x) -> x.startsWith("G");
		list.stream().filter(printStringStartWithG).forEach(System.out::println);
		
		//Print the String whose length is 4
		Predicate<String> printStringLengthIs4=x->x.length()==4;
		list.stream().filter(printStringLengthIs4).forEach(System.out::println);
		
		//Multiple Predicates in one stream.
		list.stream().filter(printStringLengthIs4.and(printStringStartWithG)).forEach(System.out::println);
		
		
		//Consumer Functional Interface
		System.out.println("Below is the output for Consumer FI");
		List<String> list1=Arrays.asList("Gyan","Gaurav","Amit","Gun1","Rishabh","gdfg");
		Consumer<List<String>> printElements=x->list1.stream().forEach(System.out::println);
		printElements.accept(list1);
		
		//Multiple Consumer
		Consumer<List<String>> changeToUpperCase=x->{
			for(int i=0;i<list1.size();i++) {
				list1.set(i, list1.get(i).toUpperCase());
			}
		};
		changeToUpperCase.andThen(printElements).accept(list1);;
		
		
		//Supplier Functional Interface
		System.out.println("Below is the output for Supplier FI");
		//Get Random Double Number 
		Supplier<Double> getRandomNumber=()->Math.random();
		System.out.println(getRandomNumber.get());
		
		//Get Random Integers which is less than 10
		Supplier<Integer> getRandomIntWithLimit=()->new Random().nextInt(10);
		System.out.println(getRandomIntWithLimit.get());
		
		//Get Random Integer
		Supplier<Integer> getRandomInteger=()->new Random().nextInt();
		System.out.println(getRandomInteger.get());
		
		
		
		
		
	}

}
