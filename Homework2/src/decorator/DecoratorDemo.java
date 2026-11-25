package decorator;

import state.Order;

import java.util.HashMap;
import java.util.Map;

public class DecoratorDemo {

    public static void main(String[] args) {

        // إنشاء طلب تجريبي
        Order order = new Order("ORD-101", "Laptop", 900.0);

        Map<String, Order> orders = new HashMap<>();
        orders.put(order.getId(), order);

        // الخدمة الأساسية
        OrderService service = new BasicOrderService(orders);

        // إضافة Caching
        service = new CachingOrderService(service);

        // إضافة Logging
        service = new LoggingOrderService(service);

        System.out.println("========== FIRST REQUEST ==========");

        System.out.println(service.getOrderDetails("ORD-101"));

        System.out.println("\n========== SECOND REQUEST ==========");

        System.out.println(service.getOrderDetails("ORD-101"));

        System.out.println("\n========== UNKNOWN ORDER ==========");

        System.out.println(service.getOrderDetails("ORD-999"));
    }
}
