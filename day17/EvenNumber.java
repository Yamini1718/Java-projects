package day17;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EvenNumber {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\yamin\\FileHandling\\number.txt";

      
        try (FileWriter writer = new FileWriter(filePath)) {
            for (int i = 0; i <= 10; i++) {
                writer.write(i + (i < 10 ? "," : ""));
            }
            System.out.println("File written successfully!");
        } catch (IOException e) {
            System.out.println("Error creating file: " + e.getMessage());
        }

     
        try (Scanner scanner = new Scanner(new File(filePath))) {
            scanner.useDelimiter(",");

            System.out.println("Even numbers from file:");
            while (scanner.hasNextInt()) {
                int num = scanner.nextInt();
                if (num % 2 == 0) {
                    System.out.print(num + " ");
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }
}

