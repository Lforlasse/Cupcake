package DBAccess;

import java.sql.*;

/**
 * 
 * @author Per, Joakim, Frederik
 */
public class DBConnector {

    //Class for connecting to DB and performing queries.

    private static Connection conn() {

        try {
            String driver, url, username, password, nameDB;
            nameDB = "cupcake";
            driver = "com.mysql.cj.jdbc.Driver";
            url = "jdbc:mysql://localhost:3306/" + nameDB + "?verifyServerCertificate=false&useSSL=true&serverTimezone=UTC";
            username = "admin";
            password = "cupcakeworld";
            Class.forName(driver);

            //System.out.println("\n--------------- MySQL ---------------");
            Connection conn = DriverManager.getConnection(url, username, password);
            //System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println("Java Exception: " + e);
        }
        return null;
    }

    public static void updateSQL(String query) {
        Statement st = null;
        try {
            try {
                st = conn().createStatement();
                st.executeUpdate(query);
                //System.out.println("SQL updated");
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("ErrorCode: " + ex.getErrorCode());
            } finally {
                if (st != null) {
                    try {
                        st.close();
                        //System.out.println("Disconnected\n");
                    } catch (SQLException sqlEx) {
                        System.out.println("SQLexception: " + sqlEx.getMessage());
                        System.out.println("SQLerror: " + sqlEx.getErrorCode());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Java Exception: " + e);
        }
    }

    public static ResultSet querySQL(String query) {
        Statement st;
        ResultSet rs = null;
        try {
            try {
                st = conn().createStatement();
                rs = st.executeQuery(query);
                //System.out.println("SQL query completed\n");
            } catch (SQLException ex) {
                System.out.println("SQLException: " + ex.getMessage());
                System.out.println("SQLState: " + ex.getSQLState());
                System.out.println("VendorError: " + ex.getErrorCode());
            }
        } catch (Exception e) {
            System.out.println("Java Exception: " + e);
        }
        return rs;
    }

    public static boolean sqlGuard() {
        try {
            if (!DBConnector.conn().isValid(2)) {
                System.out.println("Connection timeout! Aborting operation!");
                return false;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return true;
    }
}