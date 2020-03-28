package FunctionLayer;

import DBAccess.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class Order {

    public static void newOrder(int userId, double cartPrice, List<CartItem> userCart) {

        createOrder(userId, cartPrice);

        int orderId = queryOrderNumber(userId);

        createOrderContent(orderId, userCart);

        adjustUserCredit(userId, cartPrice);

    }//newOrder

    private static void createOrder(int userId, double cartPrice) {

        String query = "INSERT INTO orders (UserId,OrderPrice) " +
                "VALUES (\"" + userId + "\", " + cartPrice + ");";
        DBConnector.updateSQL(query);

    }//createOrder

    private static int queryOrderNumber(int userId) {
        int orderId = 0;

        String query = "SELECT MAX(OrderId)" +
                " FROM orders" +
                " WHERE userId = \"" + userId + "\";";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                orderId = rs.getInt("MAX(OrderId)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return orderId;
    }//queryOrderNumber

    private static void createOrderContent(int orderId, List<CartItem> userCart) {

        String query;

        for (CartItem item : userCart) {

            query = "INSERT INTO orderContent (orderId,top,bottom,quantity) " +
                    "VALUES (\"" + orderId + "\", \"" + item.getTopping() + "\", \"" + item.getBottom() + "\", " + item.getQuantity() + ");";
            DBConnector.updateSQL(query);
        }

    }//createOrderContent

    private static void adjustUserCredit(int userId, double cartPrice) {

        String query = "UPDATE users " +
                "SET Credit = Credit + -" + cartPrice +
                " WHERE UserId = \"" + userId + "\";";
        DBConnector.updateSQL(query);
    }//adjustUserCredit

    /*
    private final CartItem cartItem;

    public Order(CartItem cartItem) {
        this.cartItem = cartItem;
    }

        //TODO Metodekald på prisens prisberegning.
        private static double priceCalcOrder(){

            return 0;
        }

        //TODO Permanent creditBeregner, smides til databasen.
        //Skal modregne ordrepris fra kundens kredit.
        private static double makePayment(){

            return 0;
        }

        private static String generateInvoice(){

            return null;
        }

        //TODO her skal cart sendes til DB. OBS! gennem DBAcces.
        //skaber query. Privat-metode.
        private static void createOrderDB(){

        }

     */
}//class


