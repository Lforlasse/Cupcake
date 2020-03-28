package PresentationLayer;

import FunctionLayer.Cart;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

public class RemoveCupcake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String cartItemId = request.getParameter("itemId");
        Cart cart = (Cart)session.getAttribute("cart");
        User user = (User)session.getAttribute("user");
        try {
            cart.removeCartItem(cartItemId);
            session.setAttribute("cartItemList", user.getCart().getUserCart());
        } catch (Exception e){
            System.out.println("Java error: " + e);
        }
        session.setAttribute("cartItemList", user.getCart().getUserCart());



        System.out.println("-----------------------------------------------");
        Enumeration attributeNames = session.getAttributeNames();
        while (attributeNames.hasMoreElements()) {

            String name = (String)attributeNames.nextElement();
            String value = "value: " + session.getAttribute(name);
            System.out.println(name + "=" + value);
        }
        System.out.println("-----------------------------------------------");
        return "cart";
    }
}
