package Java.Java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student{
	int id;
	String name;
	int age;
	
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setId(int id) {
		this.id=id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public void setAge(int age) {
		this.age=age;
	}
	
	public Student(int id, String name, int age) {
		this.id=id;
		this.name=name;
		this.age=age;
	}
	
	public Student() {
		super();
	}
	
	public String toString() {
		return id+" "+name+" "+age;
	}
}

//for Ascending Order
class ageCompareAsc implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {	
		return s1.getAge()-s2.getAge();
	}	
}

class nameCompareAsc implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {	
		return s1.getName().compareTo(s2.getName());
	}	
}

class idCompareAsc implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {	
		return s1.getId()-s2.getId();
	}	
}

//for Descending Order
class ageCompareDesc implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {	
		return s2.getAge()-s1.getAge();
	}	
}

class nameCompareDesc implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {	
		return s2.getName().compareTo(s1.getName());
	}	
}

class idCompareDesc implements Comparator<Student> {
	@Override
	public int compare(Student s1, Student s2) {	
		return s2.getId()-s1.getId();
	}	
}



public class ComparatorClass {
	
	public static void main(String args[]) {
		
		ArrayList<Student> arr=new ArrayList();
		arr.add(new Student(1,"Rishabh1",23));
		arr.add(new Student(3,"Rishabh3",26));
		arr.add(new Student(5,"Rishabh4",28));
		arr.add(new Student(4,"Rishabh2",25));
		arr.add(new Student(2,"Rishabh5",21));
		
		//Compare and sort the data on the basis of student's age using comparator Inteface 
		List<Student> list=arr.stream().sorted((Student s1, Student s2)->s1.getAge()-s2.getAge()).collect(Collectors.toList());
		list.forEach(System.out::println);
		
		//Compare and sort the Employee object by student id then name and then age.
		arr.stream().sorted(new idCompareAsc().thenComparing(new nameCompareAsc().thenComparing(new ageCompareAsc())))
			.forEach(System.out::println);
		
		arr.stream().sorted(new idCompareDesc().thenComparing(new nameCompareDesc().thenComparing(new ageCompareDesc())))
		.forEach(System.out::println);
		
		List<Integer> sampleList=Arrays.asList(1,5,3,6,8,9);
		//maximum element of the list
		int max=sampleList.stream().sorted().max(Comparator.naturalOrder()).get();
		int max1=sampleList.stream().sorted().min(Comparator.reverseOrder()).get();
		
		//minimum element of the list
		int min=sampleList.stream().sorted().min(Comparator.naturalOrder()).get();
		int min1=sampleList.stream().sorted().max(Comparator.reverseOrder()).get();
		
		System.out.println("Maximum Element is "+max +" & "+ "Minimum Element is "+min);
		System.out.println("Maximum Element is "+max1 +" & "+ "Minimum Element is "+min1);
		
		//Second Highest and Lowest Element
		int secondMax=sampleList.stream().sorted(Comparator.naturalOrder()).skip(1).findFirst().get();
		int secondMin=sampleList.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst().get();
		
		System.out.println("Second Maximum Element is "+secondMax +" & "+ "Second Minimum Element is "+secondMin);
	
		//Third Highest and Lowest Element
		int thirdMax=sampleList.stream().sorted(Comparator.naturalOrder()).skip(2).findFirst().get();
		int thirdMin=sampleList.stream().sorted(Comparator.reverseOrder()).skip(2).findFirst().get();
	
		System.out.println("Third Maximum Element is "+thirdMax +" & "+ "Third Minimum Element is "+thirdMin);
		
		
		
	}

}


