package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;

import java.util.ArrayList;
import java.util.List;

public class CartItem {

    private String bottom, topping, itemId;
    private int quantity;
    private double price;
    private static List<CartItem> cartItemList;

    public static List<CartItem> getCartItemList() {
        return cartItemList;
    }

    //TESTDATA
    public static List<Item>getPopulatedCartItemList(){
        Item item1 = new Item(1, "something", 10.5, 2, 21);
        Item item2 = new Item(2, "somethingElse", 13, 2, 26);
        Item item3 = new Item(3, "somethingNew", 15, 3, 45);
        Item item4 = new Item(4, "somethingOld", 19, 1, 28);

        ArrayList<Item> itemList = new ArrayList();

        itemList.add(item1);
        itemList.add(item2);
        itemList.add(item3);
        itemList.add(item4);

        return itemList;
    }

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
            }//for bottom
        }//for topping

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

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }
}//class