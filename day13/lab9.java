package day13;
import java.util.*;
public class lab9 {

	    public static String StringOperation(String input, int choice) {
	        String result = "";

	        switch (choice) {
	            case 1:
	                result = input + input;
	                break;

	            case 2:
	                for (int i = 0; i < input.length(); i++) {
	                    if (i % 2 == 1) {
	                        result += "#";
	                    } else {
	                        result += input.charAt(i);
	                    }
	                }
	                break;

	            case 3:
	                for (int i = 0; i < input.length(); i++) {
	                    char ch = input.charAt(i);
	                    if (result.indexOf(ch) == -1) {
	                        result += ch;
	                    }
	                }
	                break;

	            case 4:
	                for (int i = 0; i < input.length(); i++) {
	                    char ch = input.charAt(i);
	                    if (i % 2 == 1) {
	                        result += Character.toUpperCase(ch);
	                    } else {
	                        result += ch;
	                    }
	                }
	                break;

	            default:
	                result = "Invalid choice!";
	        }

	        return result;
	    }

	    public static void main(String[] args) {
	        Scanner sc = new Scanner(System.in);

	        System.out.print("Enter a string: ");
	        String input = sc.nextLine();

	        System.out.println("Choose an operation:");
	        System.out.println("1. Add the string to itself");
	        System.out.println("2. Replace odd positions with #");
	        System.out.println("3. Remove duplicate characters");
	        System.out.println("4. Change odd characters to uppercase");

	        System.out.print("Enter your choice (1-4): ");
	        int choice = sc.nextInt();

	        String result =StringOperation(input, choice);
	        System.out.println("Result: " + result);

	       
	    }
	}
