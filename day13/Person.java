package day13;

public class Person {
	String FirstName;
	String LastName;
	Gender Gender1;
	enum Gender{
		M,F
	}
	Person(String FirstName,String LastName, Gender Gender1){
		this.FirstName=FirstName;
		this.LastName=LastName;
		this.Gender1=Gender1;
		
		
		
	}
	public void setFirstName(String FirstName) {
		this.FirstName=FirstName;
	}
	public void setFirstName(String LastName) {
		this.LastName=LastName;
	}
	public void setGender1(Gender Gender1) {
		this.Gender1=Gender1;
	}
	
	
	public String getFirstName() {
		return FirstName;
	}
	public String getLastName() {
		return LastName;
	}
	public Gender getGender1() {
		return  Gender1;
	}
	
	public void number(String number) {
		
		System.out.println(number);
	}
	
	
	public void display() {
		System.out.println(FirstName);
		System.out.println(LastName);
		System.out.println(Gender1);
	}
	

}
