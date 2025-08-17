package day15;

public class Main {
    public static void main(String[] args) {
        Person smith = new Person("Smith", 30.0f);
        Person kathy = new Person("Kathy", 28.5f);

        Account smithAccount = new Account(smith, 2000);
        Account kathyAccount = new Account(kathy, 3000);

        smithAccount.deposit(2000);  
        kathyAccount.withdraw(2000); 

        System.out.println(smithAccount);
        System.out.println(kathyAccount);
    }
}
