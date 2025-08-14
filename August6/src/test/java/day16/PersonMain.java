package day16;

import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter First Name: ");
            String fName = sc.nextLine();

            System.out.print("Enter Last Name: ");
            String lName = sc.nextLine();

         
            Person p= new Person(fName, lName);

            System.out.println("Full Name: " + p.getFullName());

        } catch (NameBlankException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }
}
