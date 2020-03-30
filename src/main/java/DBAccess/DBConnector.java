package DBAccess;

import java.sql.*;

public class DBConnector {
    private static String url, username, password, nameDB;
    private static Connection conn = null;
    //Class for connecting to DB and performing queries.

    /**
     *
     * @return Connection
     * @throws ClassNotFoundException Java
     * @throws SQLException MySQL
     */
    private static Connection conn() throws ClassNotFoundException, SQLException {
        if (conn == null) {
            setDBCredentials();
            Class.forName("com.mysql.cj.jdbc.Driver");
            //System.out.println("\n--------------- MySQL ---------------");
            conn = DriverManager.getConnection(url, username, password);
            //System.out.println("Connected");
        }
        return conn;
    }

    /**
     * Specifies database credentials
     */
    public static void setDBCredentials() {
        String deployed = System.getenv("DEPLOYED");
        if (deployed != null) {
            url = System.getenv("JDBC_CONNECTION_STRING");
            username = System.getenv("JDBC_USER");
            password = System.getenv("JDBC_PASSWORD");
            System.out.println("DEPLOYED: PROD selected");
            System.out.println("----------------------------");
            System.out.println(url);
            System.out.println(username);
            System.out.println(password);
            System.out.println("----------------------------");
        } else {
            nameDB = "cupcake";
            url = "jdbc:mysql://localhost:3306/" + nameDB + "?verifyServerCertificate=false&useSSL=true&serverTimezone=CET";
            username = "admin";
            password = "cupcakeworld";
            System.out.println("DEPLOYED: DEV selected");
        }
    }

    /**
     *
     * @param query Specified MySQL query
     */
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

    /**
     *
     * @param query Specified MySQL query
     * @return ResultSet containing data from database
     */
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

    /**
     *
     * @return Validation of database connection
     * @throws ClassNotFoundException Java
     */
    public static boolean sqlGuard() throws ClassNotFoundException {
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