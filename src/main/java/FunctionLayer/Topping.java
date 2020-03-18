package FunctionLayer;

import java.util.ArrayList;
import java.util.List;

public class Topping {

    private String name;
    private double price;

    public Topping(String name, double price) {
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
    private static List<Topping> toppingsList;

    //Metodekald på listen
    public static void initToppings(){
        if (toppingsList == null){
            toppingsList = new ArrayList<>();
            //Hent toppings fra database
            toppingsList.add(new Topping("Chocolate", 5.0));
            toppingsList.add(new Topping("Blueberry", 5.0));
            toppingsList.add(new Topping("Raspberry", 5.0));
            toppingsList.add(new Topping("Crispy", 6.0));
            toppingsList.add(new Topping("Strawberry", 6.0));
            toppingsList.add(new Topping("Rum/Raisin", 7.0));
            toppingsList.add(new Topping("Orange", 8.0));
            toppingsList.add(new Topping("Lemon", 8.0));
            toppingsList.add(new Topping("Blue Cheese", 9.0));
        }
    }

    public static List<Topping> getToppingsList() {
        return toppingsList;
    }
}
