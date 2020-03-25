package DBAccess;

import FunctionLayer.Topping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToppingMapper {

    public static ArrayList<Topping> getAllToppings() {
        String type;
        double price;
        ArrayList<Topping> toppingsList = new ArrayList<>();

        String query = "SELECT * FROM top;";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                type = rs.getString("TopType");
                price = rs.getDouble("Price");
                toppingsList.add(new Topping(type, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toppingsList;
    }
}
