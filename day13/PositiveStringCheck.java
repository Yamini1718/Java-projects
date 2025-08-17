package day13;

import java.util.Scanner;

public class PositiveStringCheck {

    public static boolean isPositiveString(String input) {
        input = input.toUpperCase();
        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) > input.charAt(i + 1)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (isPositiveString(str)) {
            System.out.println(str + " is a Positive String");
        } else {
            System.out.println(str + " is NOT a Positive String");
        }
    }
}

