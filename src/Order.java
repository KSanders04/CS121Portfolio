import java.util.LinkedList;

public class Order{
    double totalAmount = 0;
    private LinkedList<Pizza> pizzaLinkedList = new LinkedList<>();

    public void addPizza(Pizza pizza){
        pizzaLinkedList.add(pizza);
        totalAmount += pizza.getPizzaPrice();
    }

    public double getTotalAmount(){
        return totalAmount;
    }

    public void displayOrder(){
        if (pizzaLinkedList == null){
            System.out.println("Your order is empty.");
        }else{
            System.out.println("\nYour current order:");
            for (Pizza pizza : pizzaLinkedList){
                System.out.printf("%s: $%.2f\n",pizza.getPizzaName(), pizza.getPizzaPrice());
            }
        }
    }
}
