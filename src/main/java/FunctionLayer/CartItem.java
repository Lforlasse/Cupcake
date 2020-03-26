package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;

public class CartItem {

    private String bottom, topping, itemId;
    private int quantity;
    private double price;


    public CartItem(int quantity, String topping, String bottom) {
        this.quantity = quantity;
        this.topping = topping;
        this.bottom = bottom;
        this.price = calcPrice(quantity, topping, bottom);
        this.itemId = makeId(topping,bottom);
    }//cartItem

    public static double calcPrice(int quantity, String topping, String bottom) {
        double sum = 0;

        for (Topping top : ToppingMapper.getAllToppings()) {
            if (topping.equals(top.getType())) {
                sum += top.getPrice();
            }
        }//for topping

        for (Bottom bot : BottomMapper.getAllBottoms()) {
            if (bottom.equals(bot.getType())) {
                sum += bot.getPrice();
            }
        }//for bottom

        sum = sum*quantity;
        return sum;
    }//calcPrice

    private static String makeId(String topping,String bottom){
        String id = "CID";
        id = id+topping.toUpperCase().substring(0,2)+bottom.toUpperCase().substring(0,2);

        return id;
    }//makeId

    public String getBottom() {
        return bottom;
    }

    public void setBottom(String bottom) {
        this.bottom = bottom;
    }

    public String getTopping() {
        return topping;
    }

    public void setTopping(String topping) {
        this.topping = topping;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getItemId() {
        return itemId;
    }
}//class