package FunctionLayer;

import java.util.List;

public class CartItem {

    private String bottom, topping, itemId;
    private int quantity;
    private double price;

    public static List<CartItem> getCartItemList() {
        return cartItemList;
    }

    public CartItem(int quantity, String topping, String bottom) {
        this.quantity = quantity;
        this.topping = topping;
        this.bottom = bottom;
        this.price = calcPrice(this.topping,this.bottom,this.quantity);
        this.itemId = makeId(topping,bottom);
    }//cartItem

    private static double calcPrice(String topping, String bottom, int quantity) {
        double sum = 0;

        for (Topping top : Topping.getToppingsList()) {
            if (topping.equals(top.getType())) {
                sum += top.getPrice();
            }
        }//for topping

        for (Bottom bot : Bottom.getBottomsList()) {
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

    public static List<CartItem> cartItemList;


    private void addProduct(int quantity,String topping, String bottom) {
        String ItemId = "CID"+topping.toUpperCase().substring(0,2)+bottom.toUpperCase().substring(0,2);

        for (CartItem item : CartItem.getCartItemList()) {
            if (ItemId.equals(item.getItemId())) {
                this.setQuantity(this.getQuantity()+quantity);
                this.setPrice(calcPrice(this.topping,this.bottom,this.quantity));

            } else {
                new CartItem(quantity, topping, bottom);
            }
        }
    }//addProduct

    private void removeProduct(String itemId) {
        int listCounter = -1;
        int listSpot;

        for (CartItem item : CartItem.getCartItemList()) {

            listCounter += 1;

            if (itemId.equals(item.getItemId())) {
                listSpot = listCounter;
                getCartItemList().remove(listSpot);
            }
        }
        if (getCartItemList() != null) {
            //TODO Calculate new order price
        }
    }//removeProduct

    private void removeProductAmount(String itemId, int adjustment) {

        for (CartItem item : CartItem.getCartItemList()) {
            if (itemId.equals(item.getItemId())) {
                this.setQuantity(this.getQuantity() - quantity);
                this.setPrice(calcPrice(this.topping, this.bottom, this.quantity));
            }
        }
    }//removeProductAmount

    private void addProductAmount(String cartId, int adjustment) {

        for (CartItem item : CartItem.getCartItemList()) {
            if (itemId.equals(item.getItemId())) {
                this.setQuantity(this.getQuantity() + quantity);
                this.setPrice(calcPrice(this.topping, this.bottom, this.quantity));
            }
        }
    }//addProductAmount

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