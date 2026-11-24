package adapter;

public class ExternalPayPalLib {

    public boolean makeTransaction(double value, String currency) {
        System.out.println("[ExternalPayPalLib] Executing PayPal transaction: " + value + " " + currency);
        return true;
    }
}