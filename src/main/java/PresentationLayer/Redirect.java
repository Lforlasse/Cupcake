package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class Redirect extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String page = request.getParameter("page");
        HttpSession session = request.getSession();

        if ("assortment".equals(page)) {
            if (request.getServletContext().getAttribute("toppingList") == null) {
                request.getServletContext().setAttribute("toppingList", (List)LogicFacade.getAllToppings());
            }
            if (request.getServletContext().getAttribute("bottomList") == null) {
                request.getServletContext().setAttribute("bottomList", LogicFacade.getAllBottoms());
            }
        }

        String role = (String)session.getAttribute("role");
        if ("customer".equals(page)) {
            if (role.equals("10")) {
                page = "employee";
            }
        }

        return page;
    }
}
