package FunctionLayer;

import DBAccess.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Bottom {

    private String type;
    private double price;

    public Bottom(String type, double price) {
        this.type = type;
        this.price = price;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {

        this.type = type;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    //LISTEN
    private static List<Bottom> bottomsList;

    //Metodekald på listen
    public void initBottoms(){
        if (bottomsList == null){
            bottomsList = new ArrayList<>();

            String query =  "SELECT * FROM bottom;";
            ResultSet rs = DBConnector.querySQL(query);

            try {
                while(rs.next()) {
                    type = rs.getString("BottomType");
                    price = rs.getDouble("Price");

                    bottomsList.add(new Bottom(type,price));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

          /*bottomsList.add(new Bottom("Chocolate", 5.0));
            bottomsList.add(new Bottom("Vanilla", 5.0));
            bottomsList.add(new Bottom("Nutmeg", 5.0));
            bottomsList.add(new Bottom("Pistacio", 6.0));
            bottomsList.add(new Bottom("Almond", 7.0));*/
        }//if
    }//initToppings

    public static List<Bottom> getBottomsList() {
        return bottomsList;
    }
}//class