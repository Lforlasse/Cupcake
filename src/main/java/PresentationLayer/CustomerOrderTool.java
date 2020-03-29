package PresentationLayer;

import DBAccess.OrderMapper;
import FunctionLayer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class CustomerOrderTool extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        HttpSession session = request.getSession();

        session.setAttribute("statusList", OrderMapper.getStatusList());
        session.setAttribute("orderList", OrderMapper.seeAllOrders());
        return "customerordertool";
    }
}
