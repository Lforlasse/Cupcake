package FunctionLayer;

import DBAccess.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//public class Admin { //midlertidig class indtil User virker.
public class Admin extends User {

    public Admin(String email, String password, String role) {
       super(email, password, role);
   }//Admin


    //Vis alle ordrer fra en enkelt bruger
    public static List seeOrdersDB(int userId) {
        List<String> orderList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId;

        String query =  "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders" +
                        "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId" +
                        "WHERE UserId = " + userId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while(rs.next()) {
                orderId = rs.getInt("OrderId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                order = "Ordernumber:\t"+orderId+"\nOrderstatus:\t"+orderStatus+"\nDate:\t"+orderDate;
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }//seeOrdersDB

    //Vis alle ordrer fra en enkelt bruger ud fra ordrestatus
    public static List seeOrdersDBOnStatus(int UserId, int StatusId){

        List<String> orderList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId;

        String query =  "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders" +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId" +
                "WHERE UserId = " + UserId + " AND orders.StatusId = " + StatusId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while(rs.next()) {
                orderId = rs.getInt("OrderId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                order = "Ordernumber:\t"+orderId+".\nOrderstatus:\t"+orderStatus+".\nDate:\t"+orderDate+".";
                orderList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }//UserOrdersOnStatus

    //Vis alle ordrer
    public static List seeAllOrders(){

        List<String> allOrdersList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId, userId;

        String query =  "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders" +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId;";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while(rs.next()) {
                orderId = rs.getInt("OrderId");
                userId = rs.getInt("UserId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                order = "Usernumber:\t"+userId+".\nOrdernumber:\t"+orderId+".\nOrderstatus:\t"+orderStatus+".\nDate:\t"+orderDate+".";
                allOrdersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allOrdersList;
    }//seeAllOrders

    //Vis alle ordrer ud fra ordrestatus
    public static List SeeAllOrdersOnStatus(int StatusId){

        List<String> allOrdersList = new ArrayList<>();
        String order, orderDate, orderStatus;
        int orderId, userId;

        String query =  "SELECT OrderId, OrderDate,orderstatus.OrderStatus from orders" +
                "INNER JOIN orderstatus on orders.StatusId=orderstatus.StatusId;" +
                "WHERE orders.StatusId = " + StatusId + ";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while(rs.next()) {
                orderId = rs.getInt("OrderId");
                userId = rs.getInt("UserId");
                orderDate = rs.getString("OrderDate");
                orderStatus = rs.getString("orderstatus.OrderStatus");

                order = "Usernumber:\t"+userId+".\nOrdernumber:\t"+orderId+".\nOrderstatus:\t"+orderStatus+".\nDate:\t"+orderDate+".";
                allOrdersList.add(order);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return allOrdersList;
    }//AllOrdersOnStatus

    //Vis ordrelinjer ud fra ordrenummer
    public static Map<List,Double> OrderContent(int orderId){

        HashMap<List,Double> FullPrice = new HashMap<List, Double>();
        List<String> ContentList = new ArrayList<>();
        String content, top, bottom;
        int quantity;
        double priceTop, priceBottom;
        double priceTotal = 0;

        String query =  "SELECT Top,Bottom,Quantity,top.Price,bottom.Price from ordercontent" +
                        "INNER JOIN top on ordercontent.Top=top.TopType" +
                        "INNER JOIN bottom on ordercontent.Bottom=bottom.BottomType" +
                        "WHERE OrderId ="+orderId+";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()){
                top = rs.getString("Top");
                bottom = rs.getString("Bottom");
                quantity = rs.getInt("Quantity");
                priceTop = rs.getDouble("top.Price");
                priceBottom = rs.getDouble("bottom.Price");
                priceTotal += (priceTop + priceBottom)*quantity;


                if (quantity == 1){
                    content = quantity + " x "+bottom+" cupcake with "+top+" topping";
                } else {
                    content = quantity + " x "+bottom+" cupcakes with "+top+" topping";
                }//else

                ContentList.add(content);

            }
        } catch (SQLException e){
            e.printStackTrace();
        }

        FullPrice.put(ContentList,priceTotal);

        return FullPrice;
    }//OrderContent

    //Vis alle brugere
    public static List seeCustomersDB() {
        List<String> userList = new ArrayList<>();
        String userEmail, users;
        int userId, userCredit;

        String query =  "SELECT UserId,Email,Credit FROM users" +
                "WHERE RoleId = 20;";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while(rs.next()) {
                userId = rs.getInt("UserId");
                userEmail = rs.getString("Email");
                userCredit = rs.getInt("Credit");

                users = "UserId:\t"+userId+"\nEmail:\t"+userEmail+"\nCredit:\t"+userCredit;
                userList.add(users);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }//seeCustomersDB

    //Tilføjer positiv ændring på en brugers credit
    public static void addCustemorBalance(int userId, double creditAdjust) {

        String query =  "UPDATE users" +
                        "SET Credit = Credit + " + creditAdjust +
                        "WHERE UserId = " + userId + ";";
        DBConnector.updateSQL(query);
    }//addCustemorBalance

    //Tilfæjer negativ ændring på en brugers credit
    public static void removeCustomerBalance(int userId, double creditAdjust) {

        String query =  "UPDATE users" +
                        "SET Credit = Credit + -" + creditAdjust +
                        "WHERE UserId = " + userId + ";";
        DBConnector.updateSQL(query);
    }//removeCustomerBalance

    //Annullér en ordre som administrator
    public static void  cancelOrder(int orderId){

        String query =  "UPDATE orders" +
                        "SET StatusId = 16" +
                        "WHERE UserId = " + orderId + ";";
        DBConnector.updateSQL(query);

    }//cancelOrder

    //Sletter en ordre i DB
    public static void deleteOrder(int orderId){

        String query1 = "DELETE FROM ordercontent" +
                        "WHERE orderId = " + orderId +";";
        String query2 = "DELETE FROM orders" +
                        "WHERE orderId =" + orderId + ";";
        DBConnector.updateSQL(query1);
        DBConnector.updateSQL(query2);

    }//deleteOrder

    //skal kunne adde nyt produkt til databasen.
    private static void addProductDB() {

        }//addProductDB

    //skal kunne fjerne et produkt fra databasen.
    private static void removeProductDB() {

        }//removeProductDB

}//class
