package state;

public class DeliveredState implements OrderState{
    @Override
    public void pay(Order order) {
        System.out.println("[Error] Order " + order.getId() + " is already Delivered. Payment is not allowed.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("[Error] Cannot ship order " + order.getId() + " because it is already Delivered.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("[Error] Order " + order.getId() + " is already Delivered.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("[Error] Cannot cancel order " + order.getId() + " because it has already been Delivered.");
    }

    @Override
    public String getStateName() {
        return "Delivered";
    }
}
