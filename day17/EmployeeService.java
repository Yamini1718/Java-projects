package day17;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService {
    private List<Employee> employees = new ArrayList<>();
    private final String fileName = "employees.dat";

    public void addEmployee(Employee emp) {
        employees.add(emp);
    }

    public void writeEmployeesToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(employees);
            System.out.println("Employees written to file successfully!");
        } catch (IOException e) {
            System.out.println("Error writing employees: " + e.getMessage());
        }
    }

    public void readEmployeesFromFile() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            employees = (List<Employee>) ois.readObject();
            System.out.println("Employees read from file successfully!");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error reading employees: " + e.getMessage());
        }
    }

    public void displayEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            employees.forEach(System.out::println);
        }
    }
}



