package FunctionLayer;

import java.util.List;

import DBAccess.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {

    private static List<User> users;

    private int userId; //Burde være medlemsnr.
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private double balance = 0;
    private Cart cart; //Oprettes først når det bliver nødvændigt.
    private String phone;
    private String address;

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.userId = userId;
        this.balance = balance;
        this.phone = phone;
        this.address = address;
    }

    public static void createUser(User user) throws LoginSampleException {
        String query = "INSERT INTO users (Email, UserPassword, RoleId) " + "VALUES (\""
                + user.getEmail() + "\", \""
                + user.getPassword() + "\", \""
                + user.getRole() + "\")";
        DBConnector.updateSQL(query);
        login(user.getEmail(), user.getPassword());

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

    public static User login(String email, String password) throws LoginSampleException {
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

            if (rs.next()) {
                String role = rs.getString("RoleId");
                int userId = rs.getInt("UserId");
                User user = new User(email, password, role);
                user.setUserId(userId);
                return user;
            } else {
                throw new LoginSampleException("Could not validate user");
            }

        } catch (SQLException ex) {
            throw new LoginSampleException(ex.getMessage());
        }
    }


    //TODO Metodekald på kundens CreditSaldo
    public static int Balance() {

        return 0;
    }

    //TODO Permanent creditCalc, smides til databasen.
    public static int creditCalcUser() {

        return 0;
    }


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }


    @Override
    public String toString() {
        return "User{" + "username=" + userId + ", balance=" + balance + ", password=" + password + ", email=" + email + '}';
    }
}


//TODO, Joakims DBConnector system med queries osv.