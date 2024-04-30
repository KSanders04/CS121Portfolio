import java.util.HashMap;

public class Bank {
    private HashMap<Integer, Customer> customerHashMap = new HashMap();

    public void addCustomer(Customer customer){
        customerHashMap.put(customer.getPinNum(), customer);
    }

    public void removeCustomer(Customer customer){
        customerHashMap.remove(customer.getPinNum());
    }

    public Customer customerByPin(int pin){
        return customerHashMap.get(pin);
    }
    public String allCustomerInfo(){
        StringBuilder stringBuilder = new StringBuilder();
        for (Customer customer : customerHashMap.values()){
            stringBuilder.append(customer.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
}
