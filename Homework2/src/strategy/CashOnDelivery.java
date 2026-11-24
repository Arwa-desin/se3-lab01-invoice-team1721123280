package strategy;

// Concrete Strategy: الدفع نقداً عند الاستلام
public class CashOnDelivery implements PaymentStrategy {
    private static final double FEE = 2.0;

    @Override
    public boolean pay(double amount) {
        System.out.println("[COD] " + (amount + FEE) + "$ will be collected in cash on delivery (includes " + FEE + "$ fee).");
        return true;
    }

    @Override
    public String getName() {
        return "Cash On Delivery";
    }
}
