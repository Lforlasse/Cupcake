package FunctionLayer;

public class Item {

    private int index;
    private String produkt;
    private double pris;
    private int antal;
    private double total;

    public Item() {
    }

    public Item(int index, String produkt, double pris, int antal, double total) {
        this.index = index;
        this.produkt = produkt;
        this.pris = pris;
        this.antal = antal;
        this.total = total;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getProdukt() {
        return produkt;
    }

    public void setProdukt(String produkt) {
        this.produkt = produkt;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getAntal() {
        return antal;
    }

    public void setAntal(int antal) {
        this.antal = antal;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
