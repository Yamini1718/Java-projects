package day16;

public class Person {
    private String firstName;
    private String lastName;

  
    public Person() {
        this.firstName = "";
        this.lastName = "";
    }

   
    public Person(String firstName, String lastName) throws NameBlankException {
        if (firstName == null || firstName.trim().isEmpty() ||
            lastName == null || lastName.trim().isEmpty()) {
            throw new NameBlankException("First Name and Last Name cannot be blank!");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) throws NameBlankException {
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new NameBlankException("First Name cannot be blank!");
        }
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) throws NameBlankException {
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new NameBlankException("Last Name cannot be blank!");
        }
        this.lastName = lastName;
    }

    public String getFullName() {
        return firstName + " " + lastName;
    }
}


