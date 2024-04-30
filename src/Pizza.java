public class Pizza extends Topping{
    private String pizzaName;
    private double price;

    public Pizza(String pizzaName, double price, String toppingName, double toppingPrice){
        super(toppingName, toppingPrice);
        this.pizzaName = pizzaName;
        this.price = price;
    }

    public String getPizzaName(){
        return pizzaName;
    }

    public double getPizzaPrice(){
        return price;
    }

    public static String getPizzaNumber(int pizza) {
        if (pizza == 1) {
            System.out.println("Pepperoni Pizza Added");
            return "Pepperoni";
        } else if (pizza == 2){
            System.out.println("Veggie Pizza Added");
            return"Veggie";
        }else if (pizza == 3){
            System.out.println("Supreme Pizza Added");
            return "Supreme";
        }else {
            return null;
        }
    }

    public static double getPriceNumber(int pizza) {
        if (pizza == 1) {
            return 10.99;
        } else if (pizza == 2){
            return 9.99;
        }else if (pizza == 3){
            return 12.99;
        }else {
            return 0;
        }
    }
}
