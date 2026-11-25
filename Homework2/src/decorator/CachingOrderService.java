package decorator;

import java.util.HashMap;
import java.util.Map;

public class CachingOrderService
        extends OrderServiceDecorator {

    private final Map<String, String> cache = new HashMap<>();

    public CachingOrderService(OrderService service) {
        super(service);
    }

    @Override
    public String getOrderDetails(String orderId) {

        if (cache.containsKey(orderId)) {
            System.out.println("[CACHE] Cache HIT: " + orderId);
            return cache.get(orderId);
        }

        System.out.println("[CACHE] Cache MISS: " + orderId);

        String result = service.getOrderDetails(orderId);

        cache.put(orderId, result);

        return result;
    }
}