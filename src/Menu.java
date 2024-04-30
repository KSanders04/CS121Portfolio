import java.util.Scanner;

public class Menu {
    Scanner scan = new Scanner(System.in);
    Order order = new Order();

    public void displayMenu() {
        while (true) {
            System.out.println("\n********* MENU *********");
            System.out.println("Please make a selection:");
            System.out.println("1) Add Pizza");
            System.out.println("2) View Order");
            System.out.println("3) Checkout");
            System.out.println("4) Exit");
            System.out.print(">> ");
            int userInput = scan.nextInt();

            if (userInput == 1) {
                addPizza();
            } else if (userInput == 2) {
                viewOrder();
            } else if (userInput == 3) {
                checkout();
            } else if (userInput == 4) {
                System.out.println("Goodbye");
                System.out.println("Exiting...");
                break;
            } else {
                System.out.println("Invalid entry");
            }
        }
    }

    public void addPizza() {
        while (true) {
            System.out.println("\n********* PIZZA MENU *********");
            System.out.println("1) Pepperoni");
            System.out.println("2) Veggie");
            System.out.println("3) Supreme");
            System.out.println("4) Done");
            System.out.println("Enter pizza number or quit: ");
            int userInput = scan.nextInt();
            if (userInput >= 1 && userInput <= 3) {
                String pizzaName = Pizza.getPizzaNumber(userInput);
                double price = Pizza.getPriceNumber(userInput);
                System.out.println("\nAdd extra toppings:");
                System.out.println("1) Yes");
                System.out.println("2) No");
                System.out.print(">> ");
                int toppingInput = scan.nextInt();
                if (toppingInput == 1) {
                    System.out.println("\n********* TOPPING MENU *********");
                    System.out.println("1) Peppers");
                    System.out.println("2) Mushrooms");
                    System.out.println("3) Pineapple");
                    System.out.print(">> ");
                    int input = scan.nextInt();
                    String toppings = Topping.getTopping(input);
                    double toppingPrice = Topping.getToppingPrice(input);
                    Pizza pizza = new Pizza(pizzaName, price + toppingPrice, toppings, toppingPrice);
                    order.addPizza(pizza);
                }else if (toppingInput == 2) {
                    System.out.println("No extra toppings added.");
                    Pizza pizza = new Pizza(pizzaName, price, "", 0);
                    order.addPizza(pizza);
                    continue;
                }
            } else if (userInput == 4) {
                System.out.println("\nPizza's ordered!.");
                System.out.printf("Total amount for pizzas is $%.2f\n", order.getTotalAmount());
                return;
            } else {
                System.out.println("Invalid Number");
            }
        }
    }
        private void viewOrder(){
        order.displayOrder();
        }

        private void checkout(){
            System.out.println("Thank you for your order!");
            System.out.println("Total amount: $" + order.getTotalAmount());
        }
    }
