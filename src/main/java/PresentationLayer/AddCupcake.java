package PresentationLayer;

import FunctionLayer.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Integer.parseInt;

public class AddCupcake extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        //int userId = ((User)session.getAttribute("user")).getUserId();
        int quantity = 1;
        try {
            quantity = parseInt(request.getParameter("quantity"));
        } catch (Exception e) {
            request.setAttribute("error", "Input an integer!");
        }
        String topping = request.getParameter("topping");
        String bottom = request.getParameter("bottom");
        LogicFacade.addToCart((Cart)session.getAttribute("cart"), quantity, topping, bottom);

        //session.setAttribute("getPopulatedCartItemList", LogicFacade.getAllBottoms());
        List<String> hello = new ArrayList();
        hello.add("1");
        hello.add("1");

       session.setAttribute("items", hello);
        return "assortment";
    }
}
