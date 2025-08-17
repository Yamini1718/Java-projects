package day17;

public class Employee1 {
    private int id;
    private String name;
    private double salary;
    private String designation;
    private String insuranceScheme;

    public Employee1(int id, String name, double salary, String designation, String insuranceScheme) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.designation = designation;
        this.insuranceScheme = insuranceScheme;
    }

    public String getInsuranceScheme() {
        return insuranceScheme;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               ", Name: " + name +
               ", Salary: " + salary +
               ", Designation: " + designation +
               ", Insurance Scheme: " + insuranceScheme;
    }
}
