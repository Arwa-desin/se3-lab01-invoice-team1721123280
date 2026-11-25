package decorator;


public abstract class OrderServiceDecorator
        implements OrderService {

    protected final OrderService service;

    public OrderServiceDecorator(OrderService service) {
        this.service = service;
    }

    @Override
    public String getOrderDetails(String orderId) {
        return service.getOrderDetails(orderId);
    }
}
