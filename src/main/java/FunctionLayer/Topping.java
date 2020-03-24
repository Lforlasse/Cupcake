package FunctionLayer;

import DBAccess.DBConnector;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topping {

    private String type;
    private double price;

    public Topping(String name, double price) {
        this.type = name;
        this.price = price;
    }

    public String getType() {

        return type;
    }

    public void setType(String name) {

        this.type = name;
    }

    public double getPrice() {

        return price;
    }

    public void setPrice(double price) {

        this.price = price;
    }

    //LISTEN
    private static List<Topping> toppingsList;

    //Metodekald på listen
    public void initToppings(){
        if (toppingsList == null){
            toppingsList = new ArrayList<>();

            String query =  "SELECT * FROM top;";
            ResultSet rs = DBConnector.querySQL(query);

            try {
                while(rs.next()) {
                    type = rs.getString("TopType");
                    price = rs.getDouble("Price");

                    toppingsList.add(new Topping(type,price));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

          /*toppingsList.add(new Topping("Chocolate", 5.0));
            toppingsList.add(new Topping("Blueberry", 5.0));
            toppingsList.add(new Topping("Raspberry", 5.0));
            toppingsList.add(new Topping("Crispy", 6.0));
            toppingsList.add(new Topping("Strawberry", 6.0));
            toppingsList.add(new Topping("Rum/Raisin", 7.0));
            toppingsList.add(new Topping("Orange", 8.0));
            toppingsList.add(new Topping("Lemon", 8.0));
            toppingsList.add(new Topping("Blue Cheese", 9.0)); */
        }//if
    }//initToppings

    public static List<Topping> getToppingsList() {
        return toppingsList;
    }

}//class