package DBAccess;

import FunctionLayer.Bottom;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BottomMapper {

    public static ArrayList<Bottom> getAllBottoms() {
        String type;
        double price;
        ArrayList<Bottom> bottomsList = new ArrayList<>();

        String query = "SELECT * FROM bottom;";
        ResultSet rs = DBConnector.querySQL(query);

        try {
            while (rs.next()) {
                type = rs.getString("BottomType");
                price = rs.getDouble("Price");
                bottomsList.add(new Bottom(type, price));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bottomsList;
    }
}
