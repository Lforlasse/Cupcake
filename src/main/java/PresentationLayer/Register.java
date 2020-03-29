package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

public class Register extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        String address = request.getParameter("address");
        String phone = request.getParameter("phone");
        String fullName = request.getParameter("fullName");

        if (password1.equals(password2)) {
            try {
                LogicFacade.createUser(email, password1, fullName, phone, address);
            } catch (Exception e) {
                request.setAttribute("error", "Bruger eksisterer allerede");
            }
            User user = LogicFacade.login(email, password1);

            HttpSession session = request.getSession();

            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            session.setAttribute("email", email);
            session.setAttribute("name", user.getFullName());
            session.setAttribute("phone", user.getPhone());
            session.setAttribute("address", user.getAddress());
            session.setAttribute("userId", user.getUserId());
            session.setAttribute("balance", user.getBalance());
            session.setAttribute("cart", user.getCart());
            session.setAttribute("cartItemList", user.getCart().getUserCart());


            switch (user.getRole()) {
                case "20":
                    return "customer";
                case "10":
                    return "employee";
                default:
                    return "index";
            }
        } else {
            throw new LoginSampleException("the two passwords did not match");
        }
    }


}
