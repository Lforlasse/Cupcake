package FunctionLayer;

public class Product {

    private static int topID;
    private static int bottomID;
    private static int quantity;

    public Product(int topID, int bottomID, int quantity) {
        this.topID = topID;
        this.bottomID = bottomID;
        this.quantity = quantity;
    }
}

//TODO, queries til at hente info fra DB.
