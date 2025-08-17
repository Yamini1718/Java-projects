package day13;

import java.util.Scanner;

public class StringOperations {

    public static String performOperation(String input, int choice) {
        String result = "";

        if (choice == 1) {
            result = input + input;
        }

        else if (choice == 2) {
            for (int i = 0; i < input.length(); i++) {
                if (i % 2 == 0) {
                    result += input.charAt(i);
                } else {
                    result += "#";
                }
            }
        }

        else if (choice == 3) {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (result.indexOf(ch) == -1) {
                    result += ch;
                }
            }
        }

        else if (choice == 4) {
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (i % 2 == 0) {
                    result += ch;
                } else {
                    result += Character.toUpperCase(ch);
                }
            }
        }

        else {
            result = "Invalid choice.";
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        System.out.println("Choose an operation:");
        System.out.println("1. Add the string to itself");
        System.out.println("2. Replace odd positions with '#'");
        System.out.println("3. Remove duplicate characters");
        System.out.println("4. Change odd characters to uppercase");

        int choice = sc.nextInt();

        String output = performOperation(input, choice);
        System.out.println("Result: " + output);
    }
}
