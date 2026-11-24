package state;

public class CancelledState implements OrderState{
    @Override
    public void pay(Order order) {
        System.out.println("[Error] Cannot pay for order " + order.getId() + " because it is Cancelled.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("[Error] Cannot ship order " + order.getId() + " because it is Cancelled.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("[Error] Cannot deliver order " + order.getId() + " because it is Cancelled.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("[Error] Order " + order.getId() + " is already Cancelled.");
    }

    @Override
    public String getStateName() {
        return "Cancelled";
    }
}
