package FunctionLayer;

import java.util.List;

public class Cart {

    private int userId;
    private static List<CartItem> userCart;
    Double cartPrice;

    public Cart(int userId) {
        this.userId = userId;
        this.userCart = getUserCart();
        this.cartPrice = sumCartPrice();
    }

    private static double sumCartPrice() {
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

   public void addCartItem(int quantity, String topping, String bottom){
       getUserCart().add(new CartItem(quantity, topping, bottom));

       sumCartPrice();
   }//addCartItem

    private void removeCartItem(String itemId) {
        int listCounter = -1;
        int listSpot;

        for (CartItem item : CartItem.getCartItemList()) {

            listCounter += 1;

            if (itemId.equals(item.getItemId())) {
                listSpot = listCounter;
                getUserCart().remove(listSpot);
            }
        }
        sumCartPrice();
    }//removeCartItem

    private void removeAllCartItems(){
        userCart.removeAll(userCart);
        sumCartPrice();
    }//removeAllCartItems

    private void addCartItemAmount(String itemId, int adjustment) {

        for (CartItem item : getUserCart()) {
            if (item.getItemId().equals(itemId)) {
                item.setQuantity(item.getQuantity() + adjustment);
                item.setPrice(CartItem.calcPrice(item.getQuantity(),item.getTopping(),item.getBottom()));
            }
        }
        sumCartPrice();
    }//addCartItemAmount

    private void reduceCartItemAmount(String itemId, int adjustment) {

        for (CartItem item : CartItem.getCartItemList()) {
            if (itemId.equals(item.getItemId())) {
                item.setQuantity(item.getQuantity() - adjustment);
                item.setPrice(CartItem.calcPrice(item.getQuantity(),item.getTopping(),item.getBottom()));
            }
        }
        sumCartPrice();
    }//reduceCartItemAmount


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

