package decorator;

import state.Order;

import java.util.Map;

public class BasicOrderService implements OrderService {

    private final Map<String, Order> orders;

    public BasicOrderService(Map<String, Order> orders) {
        this.orders = orders;
    }

    @Override
    public String getOrderDetails(String orderId) {
        System.out.println("[BasicService] Fetching order: " + orderId);

        Order order = orders.get(orderId);

        if (order == null) {
            return "Order not found: " + orderId;
        }

        return order.toString();
    }
}

