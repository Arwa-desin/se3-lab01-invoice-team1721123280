package adapter;

import strategy.PaymentStrategy;

public class PayPalAdapter implements PaymentStrategy {
    private final ExternalPayPalLib payPalLib;
    private final String currency;

    public PayPalAdapter(ExternalPayPalLib payPalLib, String currency) {
        this.payPalLib = payPalLib;
        this.currency = currency;
    }

    public PayPalAdapter(ExternalPayPalLib payPalLib) {
        this(payPalLib, "USD");
    }

    public PayPalAdapter() {
        this(new ExternalPayPalLib(), "USD");
    }

    @Override
    public boolean pay(double amount) {
        boolean success = payPalLib.makeTransaction(amount, currency);
        if (success) {
            System.out.println("Paid " + amount + " " + currency + " successfully using PayPal.");
        } else {
            System.out.println("PayPal payment failed.");
        }
        return success;
    }

    @Override
    public String getName() {
        return "PayPal (" + currency + ")";
    }
}