package DBAccess;

import FunctionLayer.Cart;
import FunctionLayer.LoginSampleException;
import FunctionLayer.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class UserMapper {

    public static ArrayList<User> getAllUsers() {
        return null;
    }

    public static void createUser( User user ) throws LoginSampleException {
        String email = user.getEmail();
        String password = user.getPassword();
        String role = user.getRole();
        String query = "INSERT INTO users (Email, UserPassword, RoleId) " + "VALUES (\""
                + email + "\", \""
                + password + "\", \""
                + role + "\")";
        DBConnector.updateSQL(query);

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
        String query = "SELECT UserId, RoleId, Credit, Fullname, Phone, Address FROM users WHERE Email = \"" + email + "\" AND UserPassword = \"" + password + "\"";
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
}
