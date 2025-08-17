package day13;
import java.util.*;

public class Main1 {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		System.out.println("enter the phone number");
		String number=sc.nextLine();
		Person p=new Person("Yamini","Manchupilli",Person.Gender.F);
   p.display();
   p.number(number);
	}

}
