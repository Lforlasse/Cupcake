package DBAccess;

import FunctionLayer.Cart;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserMapper {

    public static ArrayList<User> getAllUsers() {
        return null;
    }

    public static void createUser( User user ) throws LoginSampleException {
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
       // login(email, password);



        /* LEGACY CODE
        try {
            Connection con = Connector.connection();
            String SQL = "INSERT INTO Users (email, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getEmail() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();

            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId( id );

        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
        */
    }

    public static User login( String email, String password ) throws LoginSampleException {
        String query = "SELECT UserId, RoleId, Credit, FullName, Phone, Address FROM users WHERE Email = \"" + email + "\" AND UserPassword = \"" + password + "\"";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            /* LEGACY CODE
            Connection con = Connector.connection();
            String SQL = "SELECT id, role FROM Users WHERE email = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement( SQL );
            ps.setString( 1, email );
            ps.setString( 2, password );
            */

            if ( rs.next() ) {
                String role = rs.getString( "RoleId" );
                int userId = rs.getInt( "UserId" );
                double balance = rs.getBigDecimal("Credit").doubleValue();
                String fullName = rs.getString("Fullname");
                String phone = rs.getString("Phone");
                String address = rs.getString("Address");
                User user = new User( email, password, role);
                user.setUserId( userId );
                user.setBalance(balance);
                user.setPhone(phone);
                user.setAddress(address);
                user.setFullName(fullName);
                if (user.getCart() == null){
                    user.setCart(new Cart(userId));
                }
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }

        } catch ( SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }

    //Vis alle brugere
    public static List seeAllUsers() {
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
    }//seeAllUsers

    //Tilføj positiv ændring på en brugers credit
    public static void addUserBalance(int userId, double creditAdjust) {

        String query =  "UPDATE users" +
                "SET Credit = Credit + " + creditAdjust +
                "WHERE UserId = \"" + userId + "\";";
        DBConnector.updateSQL(query);
    }//addUserBalance

    //Tilføj negativ ændring på en brugers credit
    public static void subtractUserBalance(int userId, double creditAdjust) {

        String query =  "UPDATE users" +
                "SET Credit = Credit + -" + creditAdjust +
                "WHERE UserId = \"" + userId + "\";";
        DBConnector.updateSQL(query);
    }//subtractUserBalance




}//class
