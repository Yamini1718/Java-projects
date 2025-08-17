package day15;

public class CurrentAccount extends Account {
    double overdraftLimit = 1000.0;

    public CurrentAccount(Person AccountHolder, double Balance) {
        super(AccountHolder, Balance);
    }

    @Override
    public boolean withdraw(double amount) {
        if ((Balance + overdraftLimit) >= amount) {
            Balance -= amount;
            return true;
        } else {
            System.out.println("Withdrawal denied: Overdraft limit exceeded.");
            return false;
        }
    }
}

