package FunctionLayer;

import java.util.List;

public class Cart {

    private int userId;
    private List<CartItem> userCart;
    double cartPrice;

    public Cart(int userId) {
        this.userId = userId;
        this.userCart = getUserCart();
        this.cartPrice = sumCartPrice();
    }

    //beregn indhold af userCart
    private double sumCartPrice() {
        double sum = 0;

        if (userCart.isEmpty()) {

            return 0;
        } else {

            for (CartItem item : userCart) {

                sum += item.getPrice();

            }//for
        }//else
        return sum;
    }//sumCartPrice

    //Tilføj en varelinje til userCart
    public void addCartItem(int quantity, String topping, String bottom){
        String ItemId = "CID"+topping.toUpperCase().substring(0,2)+bottom.toUpperCase().substring(0,2);
        boolean itemExists = false;

        for (CartItem item : userCart) {
            if (ItemId.equals(item.getItemId())) {
                itemExists = true;
                item.setQuantity(item.getQuantity() + quantity);
                item.setPrice(CartItem.calcPrice(item.getQuantity(), item.getTopping(), item.getBottom()));
            }
        }

        if(itemExists == false){
            userCart.add(new CartItem(quantity, topping, bottom));
        }
        sumCartPrice();
   }//addCartItem

    //Fjern en varelinje fra userCart
    private void removeCartItem(String itemId) {
        int listCounter = -1;
        int listSpot;

        for (CartItem item : userCart) {

            listCounter += 1;

            if (itemId.equals(item.getItemId())) {
                listSpot = listCounter;
                userCart.remove(listSpot);
            }
        }
        sumCartPrice();
    }//removeCartItem

    //Fjern all varelinjer fra userCart
    private void removeAllCartItems(){
        userCart.removeAll(userCart);
        sumCartPrice();
    }//removeAllCartItems

    //Forøg antallet af et produkt i en varelinje
    private void addCartItemAmount(String itemId, int adjustment) {

        for (CartItem item : userCart) {
            if (item.getItemId().equals(itemId)) {
                item.setQuantity(item.getQuantity() + adjustment);
                item.setPrice(CartItem.calcPrice(item.getQuantity(), item.getTopping(), item.getBottom()));
            }
        }
        sumCartPrice();
    }//addCartItemAmount

    //Formindsk antallet af et produkt i en varelinje
    private void reduceCartItemAmount(String itemId, int adjustment) {

        for (CartItem item : userCart) {
            if (itemId.equals(item.getItemId())) {
                item.setQuantity(item.getQuantity() - adjustment);
                if(item.getQuantity() < 1){
                    removeCartItem(itemId);
                } else {
                    item.setPrice(CartItem.calcPrice(item.getQuantity(),item.getTopping(),item.getBottom()));
                }//if
            }//if
        }//for
        sumCartPrice();
    }//reduceCartItemAmount

    //Overfør userCart varelinjer til DB
    private void createOrder(){

        Order.newOrder(this.userId, this.cartPrice, this.userCart);

        removeAllCartItems();
    }//createOrder


    public int getUserId() {
        return userId;
    }

    public List<CartItem> getUserCart() {
        return userCart;
    }

    public Double getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Double cartPrice) {
        this.cartPrice = cartPrice;
    }
}//class

