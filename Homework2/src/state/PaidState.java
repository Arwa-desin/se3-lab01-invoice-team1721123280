package state;

public class PaidState implements OrderState{
    @Override
    public void pay(Order order) {
        System.out.println("[Error] Order " + order.getId() + " is already Paid.");
    }

    @Override
    public void ship(Order order) {
        System.out.println("[State] Order " + order.getId() + " has been shipped. Transitioning: Paid -> Shipped.");
        order.setState(new ShippedState());
    }

    @Override
    public void deliver(Order order) {
        System.out.println("[Error] Cannot deliver order " + order.getId() + " before it is Shipped.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("[State] Order " + order.getId() + " has been cancelled (refund initiated). Transitioning: Paid -> Cancelled.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "Paid";
    }
}
