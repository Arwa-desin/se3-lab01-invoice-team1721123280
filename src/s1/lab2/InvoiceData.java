package s1.lab2;

import java.util.ArrayList;
import java.util.List;

public class InvoiceData {
    private final String number;
    private final String customerEmail;
    private final List<InvoiceItem> items = new ArrayList<>();

    public InvoiceData(String number, String customerEmail) {
        this.number = number;
        this.customerEmail = customerEmail;
    }
    public void addItem(String name, double price, int qty) {
        items.add(new InvoiceItem(name, price, qty));
    }
    public String getNumber() { return number; }
    public String getCustomerEmail() { return customerEmail; }
    public List<InvoiceItem> getItems() { return items; }
}