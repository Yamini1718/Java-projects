package day16;

public class Person1 {
    private String name;
    private int age;

   
    public Person1() {
        this.name = "";
        this.age = 0;
    }

 
    public Person1(String name, int age) throws AgeInvalidException {
        if (age <= 15) {
            throw new AgeInvalidException("Age must be above 15.");
        }
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) throws AgeInvalidException {
        if (age <= 15) {
            throw new AgeInvalidException("Age must be above 15.");
        }
        this.age = age;
    }
}
