package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.Cart;
import FunctionLayer.LogicFacade;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

public class CreateOrder extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();
        LogicFacade.createOrder((Cart) session.getAttribute("cart"));

        int userId = Integer.parseInt(String.valueOf(session.getAttribute("userId")));
        int orderId = OrderMapper.getLatestUserOrderId(userId);
        List<Map> latestOrder = OrderMapper.getOrderContentList(orderId);

        User user = (User)session.getAttribute("user");
        session.setAttribute("balance", user.getBalance());
        session.setAttribute("order", latestOrder);
        session.setAttribute("orderId", orderId);

        return "order";
    }
}
