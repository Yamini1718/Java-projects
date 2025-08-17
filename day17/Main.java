package day17;

public class Main {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();

        
        service.addEmployee(new Employee(101, "Alice", 55000));
        service.addEmployee(new Employee(102, "Bob", 60000));
        service.addEmployee(new Employee(103, "Charlie", 65000));

      
        service.writeEmployeesToFile();

       
        service = new EmployeeService();

        service.readEmployeesFromFile();

   
        service.displayEmployees();
    }
}
