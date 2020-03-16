package FunctionLayer;

public class CartItem {

    public CartItem(int Sum, int productID, String productName, String description, int productPrice) {
        this.Sum = Sum;
        this.productID = productID;
        this.productName = productName;
        this.description = description;
        this.productPrice = productPrice;
    }

    private int Sum;
    private int productID;
    private String productName;
    private String description;
    private int productPrice;


    private static double calcSum() {

        return 0.0;
    }

    private void addProduct() {

    }

    private void removeProduct() {

    }

    private void removeProductAmount() {

    }

    private void addProductAmount() {

    }
    //TODO skal have en arraylist af products.
    //TODO produkter skal sættes i HashMap.
    //TODO knapper til at fortsætte til kassen eller tilføj mere (servlet?).
    //TODO mus hover over produkt, skal vise et billede af produktet.

    public int getSum() {
        return Sum;
    }

    public void setSum(int sum) {
        Sum = sum;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
}