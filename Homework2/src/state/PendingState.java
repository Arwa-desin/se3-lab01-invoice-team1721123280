package state;

public class PendingState implements OrderState {
    @Override
    public void pay(Order order) {
        System.out.println("[State] Order " + order.getId() + " has been paid. Transitioning: Pending -> Paid.");
        order.setState(new PaidState());
    }

    @Override
    public void ship(Order order) {
        System.out.println("[Error] Cannot ship order " + order.getId() + " while it is Pending. Please pay first.");
    }

    @Override
    public void deliver(Order order) {
        System.out.println("[Error] Cannot deliver order " + order.getId() + " while it is Pending. Order must be paid and shipped first.");
    }

    @Override
    public void cancel(Order order) {
        System.out.println("[State] Order " + order.getId() + " has been cancelled. Transitioning: Pending -> Cancelled.");
        order.setState(new CancelledState());
    }

    @Override
    public String getStateName() {
        return "Pending";
    }
}
