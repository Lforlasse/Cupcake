package PresentationLayer;

import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Login extends Command {

    @Override
    String execute( HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        String email = request.getParameter( "email" );
        String password = request.getParameter( "password" );
        User user = LogicFacade.login( email, password );

        HttpSession session = request.getSession();

        session.setAttribute( "user", user );
        session.setAttribute( "role", user.getRole() );
        session.setAttribute("email", email);
        session.setAttribute("name", user.getFullName());
        session.setAttribute("phone", user.getPhone());
        session.setAttribute("address", user.getAddress());
        session.setAttribute("userId", user.getUserId());
        session.setAttribute("balance", user.getBalance());

        switch (user.getRole()) {
            case "20":
                return "customer";
            case "10":
                return "employee";
            default:
                session.setAttribute("error", "User role does not exist");
                return "index";
        }
    }
}
