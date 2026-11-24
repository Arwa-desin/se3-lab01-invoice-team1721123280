package strategy;

import state.Order;

// تجربة: تغيير طريقة الدفع لنفس الطلب وملاحظة اختلاف النتيجة
public class StrategyDemo {
    public static void main(String[] args) {
        Order order = new Order("ORD-1", "Laptop", 900.0);
        PaymentContext context = new PaymentContext();

        System.out.println("=== Same order, payment method #1 ===");
        context.setPaymentStrategy(new CardPayment("4111222233334444"));
        context.executePayment(order.getAmount());

        System.out.println("=== Same order, payment method #2 (switched at runtime) ===");
        context.setPaymentStrategy(new CashOnDelivery());
        context.executePayment(order.getAmount());

        System.out.println("=== Real payment through the order (State + Strategy) ===");
        order.setPaymentStrategy(new CardPayment("5500000000000004"));
        order.pay();
        System.out.println(order);
    }
}
