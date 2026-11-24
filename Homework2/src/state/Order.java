package state;

public class Order {
    private final String id;
    private final String productName;
    private final double amount;
    private OrderState currentState;

    public Order(String id, String productName, double amount) {
        this.id = id;
        this.productName = productName;
        this.amount = amount;
        this.currentState = new PendingState(); // الحالة الابتدائية لكل طلب جديد
    }

    // دوال تفويض العمليات إلى الحالة الحالية (جوهر نمط State)
    public void pay() {
        currentState.pay(this);
    }

    public void ship() {
        currentState.ship(this);
    }

    public void deliver() {
        currentState.deliver(this);
    }

    public void cancel() {
        currentState.cancel(this);
    }

    // تغيير الحالة الحالية (تستدعيها كلاسات الحالات عند الانتقال المسموح)
    public void setState(OrderState state) {
        this.currentState = state;
    }

    public OrderState getState() {
        return currentState;
    }

    public String getStatus() {
        return currentState.getStateName();
    }

    // Getters لبيانات الطلب (تخدم باقي الأنماط: Strategy, Decorator, Facade)
    public String getId() {
        return id;
    }

    public String getProductName() {
        return productName;
    }

    public double getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "Order{id='" + id + "', product='" + productName + "', amount=" + amount + ", status='" + getStatus() + "'}";
    }
}
