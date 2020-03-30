package DBAccess;

import FunctionLayer.Cart;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Indeholder alle metoder der behandler data vedr. User-klassen i FunctionLayer-package.
 *
 * @version 1.0
 * @author Joakim, Alex, Lasse, Benjamin
 * @since 30-03-2020
 */

public class UserMapper {

    /**
     * @param user Type: User
     * @throws LoginSampleException MySQL
     */
    public static void createUser(User user) throws LoginSampleException {
        String email = user.getEmail();
        String password = user.getPassword();
        String role = user.getRole();
        String address = user.getAddress();
        String phone = user.getPhone();
        String fullName = user.getFullName();

        String query = "INSERT INTO users (Email, UserPassword, RoleId, FullName, Phone, Address) " + "VALUES (\""
                + email + "\", \""
                + password + "\", \""
                + role + "\", \""
                + fullName + "\", \""
                + phone + "\", \""
                + address + "\")";
        DBConnector.updateSQL(query);
    }

    /**
     * @param email    Type: String
     * @param password Type: String
     * @return User object with user details
     * @throws LoginSampleException MySQL
     */
    public static User login(String email, String password) throws LoginSampleException {
        String query = "SELECT UserId, RoleId, Credit, FullName, Phone, Address FROM users WHERE Email = \"" + email + "\" AND UserPassword = \"" + password + "\"";
        ResultSet rs = DBConnector.querySQL(query);

        try {

            if (rs.next()) {
                String role = rs.getString("RoleId");
                int userId = rs.getInt("UserId");
                double balance = rs.getBigDecimal("Credit").doubleValue();
                String fullName = rs.getString("Fullname");
                String phone = rs.getString("Phone");
                String address = rs.getString("Address");
                User user = new User(email, password, role);
                user.setUserId(userId);
                user.setBalance(balance);
                user.setPhone(phone);
                user.setAddress(address);
                user.setFullName(fullName);
                if (user.getCart() == null) {
                    user.setCart(new Cart(userId));
                }
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    /**
     * Vis alle brugere
     *
     * @return List with hashmaps of users registered in the DB
     */
    public static ArrayList<HashMap<String, String>> seeAllUsers() {
        ArrayList<HashMap<String, String>> userList = new ArrayList<>();
        String userEmail, users;
        int userId, userCredit;

        String query = "SELECT UserId,Email,Credit FROM users " +
                "WHERE RoleId = 20;";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                userId = rs.getInt("UserId");
                userEmail = rs.getString("Email");
                userCredit = rs.getInt("Credit");

                HashMap<String, String> userHashMap = new HashMap<>();

                userHashMap.put("userId", String.valueOf(userId));
                userHashMap.put("userEmail", String.valueOf(userEmail));
                userHashMap.put("credit", String.valueOf(userCredit));

                //users = "UserId:\t" + userId + "\nEmail:\t" + userEmail + "\nCredit:\t" + userCredit;
                userList.add(userHashMap);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }//seeAllUsers

//    //Vis alle brugere
//    public static List seeAllUsers() {
//        List<String> userList = new ArrayList<>();
//        String userEmail, users;
//        int userId, userCredit;
//
//        String query = "SELECT UserId,Email,Credit FROM users" +
//                "WHERE RoleId = 20;";
//        ResultSet rs = DBConnector.querySQL(query);
//
//        try {
//            while (rs.next()) {
//                userId = rs.getInt("UserId");
//                userEmail = rs.getString("Email");
//                userCredit = rs.getInt("Credit");
//
//                users = "UserId:\t" + userId + "\nEmail:\t" + userEmail + "\nCredit:\t" + userCredit;
//                userList.add(users);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return userList;
//    }//seeAllUsers

    /**
     * Tilføj positiv ændring på en brugers credit
     *
     * @param userId       Type: Integer
     * @param creditAdjust Type: Double
     */
    public static void addUserBalance(int userId, double creditAdjust) {

        String query = "UPDATE users " +
                "SET Credit = Credit + " + creditAdjust +
                "WHERE UserId = \"" + userId + "\";";
        DBConnector.updateSQL(query);
    }//addUserBalance

    /**
     * Tilføj negativ ændring på en brugers credit
     *
     * @param userId       Type: Integer
     * @param creditAdjust Type: Double
     */
    public static void subtractUserBalance(int userId, double creditAdjust) {

        String query = "UPDATE users " +
                "SET Credit = Credit + -" + creditAdjust +
                "WHERE UserId = \"" + userId + "\";";
        DBConnector.updateSQL(query);
    }//subtractUserBalance
}//class
