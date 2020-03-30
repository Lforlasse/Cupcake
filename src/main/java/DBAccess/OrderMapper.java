package DBAccess;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapper {

    //Vis alle ordrer
    public static ArrayList<HashMap<String, String>> seeAllOrders() {

        ArrayList<HashMap<String, String>> allOrdersList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId, userId;

        String query = "SELECT OrderId, UserId, OrderDate,orderstatus.OrderStatus from orders " +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId;";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                orderId = rs.getInt("OrderId");
                userId = rs.getInt("UserId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                HashMap<String, String> orderHashMap = new HashMap<>();

                orderHashMap.put("orderId", String.valueOf(orderId));
                orderHashMap.put("userId", String.valueOf(userId));
                orderHashMap.put("orderDate", String.valueOf(orderDate));
                orderHashMap.put("orderStatus", String.valueOf(orderStatus));

                //order = "Usernumber:\t"+userId+".\nOrdernumber:\t"+orderId+".\nOrderstatus:\t"+orderStatus+".\nDate:\t"+orderDate+".";
                allOrdersList.add(orderHashMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allOrdersList;
    }//seeAllOrders

    //Get a list of status items in DB
    public static List<Map> getStatusList() {
        List<Map> statusList = new ArrayList<>();
        String statusId, orderStatus;

        String query = "SELECT * FROM orderstatus;";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                //statusId = rs.getString("StatusId");
                statusId = rs.getString("StatusId");
                orderStatus = rs.getString("OrderStatus");
                Map<String, String> map = new HashMap<>();
                map.put("statusId", statusId);
                map.put("orderStatus", orderStatus);
                statusList.add(map);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return statusList;
    }//getStatusList


    //Vis alle ordrer ud fra ordrestatus
    public static List SeeAllOrdersOnStatus(int StatusId) {

        List<String> allOrdersList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId, userId;

        String query = "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders " +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId " +
                "WHERE orders.StatusId = " + StatusId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                orderId = rs.getInt("OrderId");
                userId = rs.getInt("UserId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                order = "Usernumber:\t" + userId + ".\nOrdernumber:\t" + orderId + ".\nOrderstatus:\t" + orderStatus + ".\nDate:\t" + orderDate + ".";
                allOrdersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allOrdersList;
    }//SeeAllOrdersOnStatus

    //Vis alle ordrer fra en enkelt bruger
    public static List seeUserOrdersDB(int userId) {
        List<String> orderList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId;

        String query = "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders " +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId " +
                "WHERE UserId = " + userId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                orderId = rs.getInt("OrderId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                order = "Ordernumber:\t" + orderId + "\nOrderstatus:\t" + orderStatus + "\nDate:\t" + orderDate;
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }//seeUserOrdersDB

    //Vis alle ordrer fra en enkelt bruger
    public static List getUserOrders(int userId) {
        List<Map> userOrderList = new ArrayList<>();
        String orderDate, orderStatus;
        int orderId;

        String query = "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders " +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId " +
                "WHERE UserId = " + userId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                orderId = rs.getInt("OrderId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");
                Map<String, String> map = new HashMap<>();
                map.put("orderId", "" + orderId);
                map.put("orderDate", "" + orderDate);
                map.put("orderStatus", "" + orderStatus);
                userOrderList.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userOrderList;
    }//seeUserOrdersDB

    public static int getLatestUserOrderId(int userId) {
        int orderId = 0;

        String query = "SELECT MAX(OrderId) AS OrderId FROM orders " +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId " +
                "WHERE UserId = " + userId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                orderId = rs.getInt("OrderId");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderId;
    }//seeUserOrdersDB

    //Vis alle ordrer fra en enkelt bruger ud fra ordrestatus
    public static List seeUserOrdersDBOnStatus(int UserId, int StatusId) {

        List<String> orderList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId;

        String query = "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders " +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId " +
                "WHERE UserId = " + UserId + " AND orders.StatusId = " + StatusId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                orderId = rs.getInt("OrderId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                order = "Ordernumber:\t" + orderId + ".\nOrderstatus:\t" + orderStatus + ".\nDate:\t" + orderDate + ".";
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }//seeUserOrdersDBOnStatus

    //Vis varelinjer ud fra ordrenummer
    public static Map<List, Double> seeOrderContent(int orderId) {

        HashMap<List, Double> FullPrice = new HashMap<List, Double>();
        List<String> ContentList = new ArrayList<>();
        String content, top, bottom;
        int quantity;
        double priceTop, priceBottom;
        double priceTotal = 0;

        String query = "SELECT Top,Bottom,Quantity,top.Price,bottom.Price from ordercontent " +
                "INNER JOIN top on ordercontent.Top=top.TopType " +
                "INNER JOIN bottom on ordercontent.Bottom=bottom.BottomType " +
                "WHERE OrderId =" + orderId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                top = rs.getString("Top");
                bottom = rs.getString("Bottom");
                quantity = rs.getInt("Quantity");
                priceTop = rs.getDouble("top.Price");
                priceBottom = rs.getDouble("bottom.Price");
                priceTotal += (priceTop + priceBottom) * quantity;


                if (quantity == 1) {
                    content = quantity + " x " + bottom + " cupcake with " + top + " topping";
                } else {
                    content = quantity + " x " + bottom + " cupcakes with " + top + " topping";
                }//else

                ContentList.add(content);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        FullPrice.put(ContentList, priceTotal);

        return FullPrice;
    }//seeOrderContent

    public static List<Map> getOrderContentList(int orderId) {
        List<Map> ContentList = new ArrayList<>();
        String top, bottom, id;
        int quantity;
        double priceTop, priceBottom, priceTotal = 0, priceSingle = 0, priceSum = 0;

        String query = "SELECT Top,Bottom,Quantity,top.Price,bottom.Price from ordercontent " +
                "INNER JOIN top on ordercontent.Top=top.TopType " +
                "INNER JOIN bottom on ordercontent.Bottom=bottom.BottomType " +
                "WHERE OrderId =" + orderId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                top = rs.getString("Top");
                bottom = rs.getString("Bottom");
                quantity = rs.getInt("Quantity");
                priceTop = rs.getDouble("top.Price");
                priceBottom = rs.getDouble("bottom.Price");
                priceSingle = priceTop + priceBottom;
                priceTotal = (priceTop + priceBottom) * quantity;
                priceSum += (priceTop + priceBottom) * quantity;
                id = "CID" + top.toUpperCase().substring(0, 2) + bottom.toUpperCase().substring(0, 2);

                Map<String, String> map = new HashMap<>();
                map.put("quantity", "" + quantity);
                map.put("topping", top);
                map.put("bottom", bottom);
                map.put("priceSingle", "" + priceSingle);
                map.put("priceTotal", "" + priceTotal);
                map.put("priceSum", "" + priceSum);
                map.put("productId", id);

                //System.out.println(top + " | " + bottom + " | " + quantity + " | " + priceTop + " | " + priceBottom + " | " + priceSingle + " | " + priceTotal + " | " + id);
                ContentList.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ContentList;
    }//seeOrderContent

    //Annuller ordre som administrator
    public static void cancelOrderAdmin(int orderId) {
        String query = "UPDATE orders" +
                "SET StatusId = 16" +
                "WHERE UserId = " + orderId + ";";
        DBConnector.updateSQL(query);
    }//cancelOrderAdmin

    //Annuller ordre som bruger
    public static void cancelOrderUser(int orderId) {
        String query = "UPDATE orders" +
                "SET StatusId = 15" +
                "WHERE UserId = " + orderId + ";";
        DBConnector.updateSQL(query);
    }//cancelOrderAdmin

    public static void setOrderStatus(int statusId, int userId, int orderId) {
        String query = "UPDATE orders " +
                "SET StatusId = " + statusId + " " +
                "WHERE UserId = " + userId + " " +
                "AND OrderId = " + orderId + ";";
        DBConnector.updateSQL(query);
    }

    //Slet ordre i databasen
    public static void deleteOrder(String orderId) {

        String query1 = "DELETE FROM ordercontent " +
                "WHERE orderId = " + orderId + ";";
        String query2 = "DELETE FROM orders " +
                "WHERE orderId = " + orderId + ";";
        DBConnector.updateSQL(query1);
        DBConnector.updateSQL(query2);

    }//deleteOrder

}//OrderMapper