package strategy;

// Strategy Pattern: Context — يحتفظ بالاستراتيجية الحالية ويسمح بتبديلها وقت التشغيل
public class PaymentContext {
    private PaymentStrategy strategy;

    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public PaymentStrategy getPaymentStrategy() {
        return strategy;
    }

    // ينفّذ الدفع عبر الاستراتيجية الحالية دون أي if/else أو switch لاختيار الطريقة
    public boolean executePayment(double amount) {
        return strategy.pay(amount);
    }
}
