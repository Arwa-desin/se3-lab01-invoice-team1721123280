package decorator;



public class LoggingOrderService
        extends OrderServiceDecorator {

    public LoggingOrderService(OrderService service) {
        super(service);
    }

    @Override
    public String getOrderDetails(String orderId) {

        System.out.println("[LOG] Request started for: " + orderId);

        String result = service.getOrderDetails(orderId);

        System.out.println("[LOG] Request completed for: " + orderId);

        return result;
    }
}
