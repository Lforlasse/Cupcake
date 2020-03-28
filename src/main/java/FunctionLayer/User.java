package FunctionLayer;

import java.util.List;

import DBAccess.DBConnector;
import java.sql.ResultSet;
import java.sql.SQLException;


public class User {

    private static List<User> users;

    private int userId;
    private String email;
    private String password; // Should be hashed and secured
    private String role;
    private double balance = 0;
    private Cart cart; //Oprettes først når det bliver nødvendigt.
    private String phone;
    private String address;
    private String fullName;

    public User(String email, String password, String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }

// User creation constructor
    public User(String email, String password, String role,String phone, String address, String fullName) {
        this.email = email;
        this.password = password;
        this.role = role;
        this.address = address;
        this.phone = phone;
        this.fullName = fullName;
    }

    //TODO Metodekald på kundens CreditSaldo
    public static int Balance() {

        return 0;
    }

    //TODO Permanent creditCalc, smides til databasen.
    public static int creditCalcUser() {

        return 0;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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