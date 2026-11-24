package strategy;

// Concrete Strategy: الدفع بالبطاقة
public class CardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public boolean pay(double amount) {
        String last4 = cardNumber.substring(cardNumber.length() - 4);
        System.out.println("[Card] Charged " + amount + "$ to card ****" + last4 + " (no extra fee).");
        return true;
    }

    @Override
    public String getName() {
        return "Card";
    }
}
