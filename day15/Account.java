package day15;

public abstract class Account {
 static long count=10000;
 long AccountNumber;
 double Balance;
 Person AccountHolder;
 
 Account(Person AccountHolder,double Balance)
 {
	  this.AccountNumber=++count;
	  
	  if(Balance>=500) 
	  {
		  this.Balance=Balance;
	  }
	  else
	  {
		  System.out.println("Balnce must be at least 500 Rupees");
		  this.Balance=500;
	  }
	  this.AccountHolder=AccountHolder;
	  
 }
 
 public int getAccountNumber() {
	  return (int)AccountNumber;
 }
 public double getBalance() {
	  return Balance;
 }
 public Person getAccountHolder() {
	  return AccountHolder;
 }
 
 public void setBalance(float Balance) {
	  this.Balance=Balance;
 }
 public void setAccountNumber(long AccountNumber) {
	  this.AccountNumber=AccountNumber;
 }
 public void setAccountHolder(Person AccountHolder) {
	  this.AccountHolder=AccountHolder;
 }
 
 public void deposit(double Amount) {
	  Balance+=Amount;
 }
 
 
 public abstract void withdraw(double Amount);
 
 public String toString() {
	 return "Account Number:"+ AccountNumber +"Name"+AccountHolder+"Balance"+Balance;
 }
}
