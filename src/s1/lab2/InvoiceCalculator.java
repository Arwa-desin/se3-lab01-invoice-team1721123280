package s1.lab2;

public class InvoiceCalculator {
    public double calculateTotal(InvoiceData data) {
        double sum = 0;
        for (InvoiceItem item : data.getItems()) {
            sum += item.getPrice() * item.getQty();
        }
        if (sum > 1000) {
            sum = sum * 0.95;
        }
        return sum * 1.15;
    }
}