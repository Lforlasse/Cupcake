package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class CustomerOrderUpdate extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        String orderStatus = request.getParameter("orderStatus");
        int orderId = Integer.parseInt(request.getParameter("orderId"));
        int userId = Integer.parseInt(request.getParameter("userId"));
        int statusId = 50;

        for (Map map : OrderMapper.getStatusList()) {
            if (map.get("orderStatus").equals(orderStatus)) {
                statusId = Integer.parseInt((String)map.get("statusId"));
            }
        }
        OrderMapper.setOrderStatus(statusId, userId, orderId);
        session.setAttribute("userOrderList", OrderMapper.getUserOrders(userId));
        User user = (User)session.getAttribute("user");
        session.setAttribute("balance", user.getBalance());
        return "customerordertool";
    }
}
