import java.util.ArrayList;

public class Customer {
    private String firstName;
    private String lastName;
    private int pinNum;
    private ArrayList<Account> accountArrayList = new ArrayList<>();

    public Customer(String firstName, String lastName, int pinNum){
        this.firstName = firstName;
        this.lastName = lastName;
        this.pinNum = pinNum;
    }

    public void addAcount(Account account){
        accountArrayList.add(account);
    }

    public void removeAccount(Account account){
        accountArrayList.remove(account);
    }
    public Account getAccount(int accountNumber){
        Account foundAccountNum = null;
        for(Account account: accountArrayList){
            if(account.getAccountNum() == accountNumber){
                return account;
            }
        }
        return foundAccountNum;
    }

    public String getAllAccountInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Account account : accountArrayList){
            stringBuilder.append(account.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
    @Override
    public String toString(){
        return String.format("Name: %s %s\nPin: %d", firstName, lastName, pinNum);
    }
    public int getPinNum(){
        return pinNum;
    }
}
