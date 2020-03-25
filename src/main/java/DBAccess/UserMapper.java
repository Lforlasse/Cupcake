package DBAccess;

import FunctionLayer.LoginSampleException;
import FunctionLayer.User;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 The purpose of UserMapper is to...

 @author kasper
 */
public class UserMapper {

    public static void createUser( User user ) throws LoginSampleException {
        String email = user.getEmail();
        String password = user.getPassword();
        String role = user.getRole();
        String query = "INSERT INTO users (Email, UserPassword, RoleId) " + "VALUES (\""
                + email + "\", \""
                + password + "\", \""
                + role + "\")";
        DBConnector.updateSQL(query);
        login(email, password);

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
        String query = "SELECT UserId, RoleId FROM users WHERE Email = \"" + email + "\" AND UserPassword = \"" + password + "\"";
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
                int id = rs.getInt( "UserId" );
                User user = new User( email, password, role );
                user.setUserId( id );
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }

        } catch ( SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }
}
