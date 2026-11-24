package strategy;

// Strategy Pattern: الواجهة المشتركة لكل طرق الدفع
public interface PaymentStrategy {
    boolean pay(double amount);
    String getName();
}
