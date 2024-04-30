public class Account {
    private double balance;
    private int accountNum;
    private static int numberOfAccounts = 1000;

    public Account(double initialDeposit){
        this.balance = initialDeposit;
        this.accountNum = numberOfAccounts++;
    }

    public int getAccountNum(){
        return accountNum;
    }
    public double getBalance(){
        return balance;
    }

    public void deposit(double amount){
        balance += amount;
        System.out.printf("You have deposited $%.2f\n", amount);
        System.out.printf("You now have a balance of $%.2f\n", balance);
    }
    public void withdraw(double amount) {
        if (balance < amount) {
            System.out.println("You have insufficient funds");
        } else {
            balance -= amount;
            System.out.printf("You have withdrawn $%.2f ", amount);
            System.out.printf("\nYou now have a balance of $%.2f\n", balance);
        }
    }
    public String toString(){
            return String.format("Account Number: %d\nBalance: $%.2f\n", accountNum, balance);
        }
}
