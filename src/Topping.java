public class Topping {
    private String toppingsName;
    private double price;

    public Topping(String toppingsName, double price) {
        this.toppingsName = toppingsName;
        this.price = price;
    }

    public static String getTopping(int topping){
        if(topping == 1){
            System.out.println("Peppers added to Pizza.");
            return "Peppers";
        }else if (topping == 2){
            System.out.println("Mushrooms added to Pizza.");
            return "Mushrooms";
        } else if (topping == 3) {
            System.out.println("Pineapple added to Pizza.");
            return "Pineapple";
        }else{
            System.out.println("Invalid Choice");
            return null;
        }
    }

    public static double getToppingPrice(int topping) {
        if (topping >= 1 && topping <= 3) {
            return 1.23;
        }else {
            return 0;
        }
    }
}
