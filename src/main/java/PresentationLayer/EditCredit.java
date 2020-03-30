package PresentationLayer;

import DBAccess.UserMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class EditCredit extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();
        double editCredit = 0;
        try {
            Double.parseDouble(request.getParameter("editCredit"));
        } catch (Exception e) {
            System.out.println(e);
        }

        int userId = Integer.parseInt(request.getParameter("userId"));

        UserMapper.addUserBalance(userId, editCredit);
        session.setAttribute("userList", UserMapper.seeAllUsers());

        return "customerCreditTool";
    }
}
