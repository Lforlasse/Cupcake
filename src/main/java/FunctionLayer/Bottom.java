package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Bottom {

    private String name;
    private double price;

    public Bottom(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
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
    public static void initToppings(){
        if (bottomsList == null){
            bottomsList = new ArrayList<>();
            //Hent bottoms fra database
            bottomsList.add(new Bottom("Chocolate", 5.0));
            bottomsList.add(new Bottom("Vanilla", 5.0));
            bottomsList.add(new Bottom("Nutmeg", 5.0));
            bottomsList.add(new Bottom("Pistacio", 6.0));
            bottomsList.add(new Bottom("Almond", 7.0));
        }
    }

    public static List<Bottom> getBottomsList() {
        return bottomsList;
    }
}
