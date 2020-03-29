package FunctionLayer;

import DBAccess.BottomMapper;
import DBAccess.ToppingMapper;
import DBAccess.UserMapper;

import java.util.ArrayList;
import java.util.List;

public class LogicFacade {

    public static User login( String email, String password ) throws LoginSampleException {
        return UserMapper.login( email, password );
    }

    public static User createUser( String email, String password, String fullName, String phone, String address) throws LoginSampleException {
        User user = new User(email, password, "20",  fullName,  phone, address);
        UserMapper.createUser( user );
        return user;
    }

    public static ArrayList<Topping> getAllToppings(){
        return ToppingMapper.getAllToppings();
    }

    public static ArrayList<Bottom> getAllBottoms(){
        return BottomMapper.getAllBottoms();
    }

    public static void addToCart(Cart cart, int quantity, String topping, String bottom) {
        cart.addCartItem(quantity, topping, bottom);
    }

    public static <cartItem> void removeFromCart(Cart cart, cartItem cartItem) {
    }

    public static void createOrder(Cart cart) {
        int userId = cart.getUserId();
        double cartPrice = cart.getCartPrice();
        List<CartItem> userCart = cart.getUserCart();
        Order.newOrder(userId, cartPrice, userCart);
    }

    public static Order getLatestOrder(User user) {
        return null;
    }

}
