package FunctionLayer;

public class Order {

    private final CartItem cartItem;

    public Order(CartItem cartItem) {
        this.cartItem = cartItem;
    }

        //TODO Metodekald på prisens prisberegning.
        private static double priceCalcOrder(){

            return 0;
        }

        //TODO Permanent creditBeregner, smides til databasen.
        //Skal modregne ordrepris fra kundens kredit.
        private static double makePayment(){

            return 0;
        }

        private static String generateInvoice(){

            return null;
        }

        //TODO her skal cart sendes til DB. OBS! gennem DBAcces.
        //skaber query. Privat-metode.
        private static void createOrderDB(){

        }
}


