import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    Bank bank = new Bank();

    public void displayMenu() {
        while (true) {
            System.out.println("\n********* MENU *********\n");
            System.out.println("Please make a selection:");
            System.out.println("1) Access Account");
            System.out.println("2) Open a New Account");
            System.out.println("3) Close All Accounts");
            System.out.println("4) Exit");
            System.out.print(">> ");
            int userInput = scan.nextInt();

            if (userInput == 1) {
                accessAccount();
            } else if (userInput == 2) {
                openNewAccount();
            } else if (userInput == 3) {
                closeAllAccounts();
            } else if (userInput == 4) {
                System.out.println("Thank you for using BSU Banking App");
                System.out.println("Goodbye. Exiting...");
                break;
            } else {
                System.out.println("Invalid entry");
            }
        }
    }

    public void accessAccount() {
        System.out.println("Please enter your PIN:");
        int pin = scan.nextInt();
        Customer customer = bank.customerByPin(pin);
        if (customer == null) {
            System.out.println("PIN is invalid");
            return;
        }
        System.out.println("***Active Accounts***");
        System.out.println(customer.getAllAccountInfo());
        System.out.println("Please enter the account number");
        System.out.print("of the account you would like to access: ");
        int accountNum = scan.nextInt();
        Account account = customer.getAccount(accountNum);
        if (account == null) {
            System.out.println("Account number is invalid");
            return;
        }
        while (true) {
            System.out.printf("\nPlease make a selection:\n");
            System.out.println("1) Make a deposit");
            System.out.println("2) Make a withdrawal");
            System.out.println("3) See account balance");
            System.out.println("4) Close account");
            System.out.println("5) Exit");
            System.out.print(">> ");
            int userInput = scan.nextInt();

            if (userInput == 1) {
                System.out.println("Enter the amount of deposit:");
                double deposit = scan.nextDouble();
                account.deposit(deposit);
            } else if (userInput == 2) {
                System.out.println("Enter the amount of withdrawal:");
                double withdrawal = scan.nextDouble();
                account.withdraw(withdrawal);
            } else if (userInput == 3) {
                System.out.printf("Account %d balance: $%.2f\n", accountNum, account.getBalance());
            } else if (userInput == 4) {
                System.out.printf("\nAccount number %d closed.\n", accountNum);
                customer.removeAccount(account);
            } else if (userInput == 5) {
                return;
            }
        }
    }

    public void openNewAccount() {
        System.out.println("Are you a new customer?");
        System.out.println("1) Yes");
        System.out.println("2) No");
        int userInput = scan.nextInt();
            if (userInput == 1) {
                Customer newCustomer = createNewCustomer();
                System.out.println("Please enter deposit amount: ");
                double deposit = scan.nextDouble();
                Account account = new Account(deposit);
                newCustomer.addAcount(account);
                System.out.println("New Account Opened: " + account.getAccountNum());
            } else if (userInput == 2) {
                System.out.println("Please enter in PIN: ");
                int userPin = scan.nextInt();
                Customer currentCustomer = bank.customerByPin(userPin);
                if (currentCustomer == null) {
                    System.out.println("PIN is invalid.");
                    return;
                }
                System.out.println("Please enter deposit amount: ");
                double deposit = scan.nextDouble();
                Account account = new Account(deposit);
                currentCustomer.addAcount(account);
                System.out.println("New Account Opened: " + account.getAccountNum());
            }
        }
    public Customer createNewCustomer() {
        System.out.println("Please enter your first name:");
        String firstName = scan.next();
        System.out.println("Please enter your last name:");
        String lastName = scan.next();
        System.out.println("Please enter a 4 digit PIN:");
        int newPIN = scan.nextInt();
        Customer customer = new Customer(firstName, lastName, newPIN);
        bank.addCustomer(customer);
        return customer;
    }
    public void closeAllAccounts(){
        System.out.println("Please enter your PIN:");
        int pin = scan.nextInt();
        Customer customer = bank.customerByPin(pin);
        if (bank.customerByPin(pin) == null){
            System.out.println("PIN is not valid.");
            return;
        }
        bank.removeCustomer(customer);
        System.out.println("You have been removed from the bank registry.");
    }
}
