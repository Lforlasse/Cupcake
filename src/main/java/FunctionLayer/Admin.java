package FunctionLayer;

import DBAccess.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Admin extends User {

    public Admin(String email, String password, String role) {
       super(email, password, role);
   }//Admin

    //skal kunne adde nyt produkt til databasen.
    private static void addProductDB() {
        //TODO not in scope
        }//addProductDB

    //skal kunne fjerne et produkt fra databasen.
    private static void removeProductDB() {
//TODO not in scope
        }//removeProductDB

}//class
