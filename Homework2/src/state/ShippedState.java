package state;

public class ShippedState implements OrderState{
    @Override
    public void pay(Order order) {
        System.out.println("[Error] Order " + order.getId() + " is already Paid and Shipped.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("[Error] Order " + order.getId() + " is already Shipped.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("[State] Order " + order.getId() + " has been delivered. Transitioning: Shipped -> Delivered.");
        order.setState(new DeliveredState());
    }

    @Override
    public void cancel(Order order) {
        System.out.println("[Error] Cannot cancel order " + order.getId() + " because it has already been Shipped.");
    }

    @Override
    public String getStateName() {
        return "Shipped";
    }
}
