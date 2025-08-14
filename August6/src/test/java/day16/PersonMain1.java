package day16;
import java.util.Scanner;
public class PersonMain1 {

	

	
	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        try {
	            System.out.print("Enter Name: ");
	            String name = sc.nextLine();

	            System.out.print("Enter Age: ");
	            int age = sc.nextInt();

	           
	            Person1 p = new Person1(name, age);

	            System.out.println("Person created successfully!");
	            System.out.println("Name: " + p.getName());
	            System.out.println("Age: " + p.getAge());

	        } catch (AgeInvalidException e) {
	            System.out.println("Error: " + e.getMessage());
	        } finally {
	            sc.close();
	        }
	    }
	}

