package day17;

import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        EmployeeService1 service = new EmployeeService1();
        int choice;

        do {
            System.out.println("\n--- Employee Management Menu ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Display Employees by Insurance Scheme");
            System.out.println("3. Delete Employee");
            System.out.println("4. Display All Employees");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine(); // consume newline
                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = sc.nextDouble();
                    sc.nextLine();
                    System.out.print("Enter Designation: ");
                    String desig = sc.nextLine();
                    System.out.print("Enter Insurance Scheme: ");
                    String scheme = sc.nextLine();

                    Employee1 emp = new Employee1(id, name, salary, desig, scheme);
                    service.addEmployee(emp);
                    System.out.println("Employee added successfully!");
                    break;

                case 2:
                    sc.nextLine();
                    System.out.print("Enter Insurance Scheme to search: ");
                    String searchScheme = sc.nextLine();
                    service.displayByScheme(searchScheme);
                    break;

                case 3:
                    System.out.print("Enter Employee ID to delete: ");
                    int delId = sc.nextInt();
                    service.deleteEmployee(delId);
                    break;

                case 4:
                    service.displayAll();
                    break;

                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        } while (choice != 5);

        sc.close();
    }
}


