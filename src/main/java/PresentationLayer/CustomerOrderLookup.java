package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerOrderLookup extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        int lookupUserId = 0;
        try {
            lookupUserId = Integer.parseInt(request.getParameter("lookupUserId"));
        } catch (Exception e) {
            request.setAttribute("error", "Indtast et tal!");
            System.out.println(e);
            return "customerorderlookuptool";
        }
        session.setAttribute("lookupUserId", lookupUserId);
        session.setAttribute("statusList", OrderMapper.getStatusList());
        session.setAttribute("userOrderList", OrderMapper.getUserOrders(lookupUserId));
        return "customerordertool";
    }
}
