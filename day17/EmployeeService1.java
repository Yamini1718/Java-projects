package day17;

import java.util.HashMap;
import java.util.Map;

public class EmployeeService1{
    private Map<Integer, Employee> empMap = new HashMap<>();

    // Add employee to map
    public void addEmployee(Employee1 emp) {
        empMap.put(emp.getId(), emp);
    }

    // Display employees by Insurance Scheme
    public void displayByScheme(String scheme) {
        boolean found = false;
        for (Employee e : empMap.values()) {
            if (e.getInsuranceScheme().equalsIgnoreCase(scheme)) {
                System.out.println(e);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No employees found with scheme: " + scheme);
        }
    }

    // Delete employee by ID
    public void deleteEmployee(int id) {
        if (empMap.remove(id) != null) {
            System.out.println("Employee removed successfully!");
        } else {
            System.out.println("Employee not found!");
        }
    }

    // Display all employees
    public void displayAll() {
        if (empMap.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            for (Employee e : empMap.values()) {
                System.out.println(e);
            }
        }
    }
}
