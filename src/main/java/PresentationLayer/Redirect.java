package PresentationLayer;

import FunctionLayer.Bottom;
import FunctionLayer.LoginSampleException;
import FunctionLayer.Topping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String page = request.getParameter("page");

        if ("assortment".equals(page)) {
            if (request.getServletContext().getAttribute("toppingList") == null) {
                request.getServletContext().setAttribute("toppingList", Topping.getToppingsList());
            }
            if (request.getServletContext().getAttribute("bottomList") == null) {
                request.getServletContext().setAttribute("bottomList", Bottom.getBottomsList());
            }
        }

        return page;
    }
}
