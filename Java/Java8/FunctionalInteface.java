package Java.Java8;

import java.util.List;

@FunctionalInterface
interface FunctionalInterF{
	int getSum(int a, int b);
	default int findMax(int a, int b) {
		return a>b?a:b;
	}
	static int findMin(int a, int b) {
		return a<b?a:b;
	}
	
}

class FunctionalInterFImpl implements FunctionalInterF{

	@Override
	public int getSum(int a, int b) {
		return a+b;
	}	
	
}

public class FunctionalInteface {
	public static void main(String args[]) {
		
		//Functional Interface implementation using Lambda Expression
		FunctionalInterF FIImpl=(int a, int b)->{
			return a+b;
		};
		int sum=FIImpl.getSum(4, 6);
		System.out.println("Sum is "+sum);
		
		//Conventional Functional Interface implementation.
		FunctionalInterF FIImpl1=new FunctionalInterFImpl();
		int sum1=FIImpl1.getSum(10, 20);
		System.out.println("Sum is "+sum1);
		
		//Default Function implementation in Functional Interface
		int max=FIImpl1.findMax(10, 15);
		System.out.println("Max. element is "+max);	
		
		//Static Function impelmentation in Functional Interface
		int min=FunctionalInterF.findMin(10,20);
		System.out.println("Minimum element is "+min);
		
		
		
	}

}

