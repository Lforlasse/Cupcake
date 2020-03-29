package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

public class RemoveOrder extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        HttpSession session = request.getSession();

        String orderId = request.getParameter("orderId");
        OrderMapper.deleteOrder(orderId);
        session.setAttribute("orderList", OrderMapper.seeAllOrders());

        return "orderTool";
    }
}
