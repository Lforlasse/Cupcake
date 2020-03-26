package PresentationLayer;

import FunctionLayer.Topping;
import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String listSelect = request.getParameter("list");
        switch (listSelect) {
            case "topping": request.setAttribute("toppingList", Topping.getToppingsList());
            case "bottom": request.setAttribute("bottomList", Bottom.getBottomsList());
            //TODO case "cart": request.setAttribute("cartList", Cart.getCartList);
            //TODO case "cartItem": request.setAttribute("cartItemList", CartItem.getCartItemList());
        }
        return "test test test";
    }
}
