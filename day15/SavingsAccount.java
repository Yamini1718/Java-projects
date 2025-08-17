package day15;

public class SavingsAccount extends Account {
    final double minimumBalance = 500.0;

    public SavingsAccount(Person AccountHolder, double Balance) {
        super(AccountHolder, Balance);
    }

    @Override
    public void withdraw(double amount) {
        if ((Balance - amount) >= minimumBalance) {
            Balance -= amount;
        } else {
            System.out.println("Withdrawal denied: Minimum balance of " + minimumBalance + " must be maintained.");
        }
    }
}



