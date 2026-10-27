package s1.lab1;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Invoice {
    public static final List<String> DATABASE = new ArrayList<>();
    public static final List<String> FILES = new ArrayList<>();

    private String number;
    private String customerEmail;
    private List<InvoiceItem> items = new ArrayList<>();

    public Invoice(String number, String customerEmail) {
        this.number = number;
        this.customerEmail = customerEmail;
    }

    public void addItem(String name, double price, int qty) {
        items.add(new InvoiceItem(name, price, qty));
    }

    public List<InvoiceItem> getItems() { return items; }

    public double calculateTotal() {
        double sum = 0;
        for (InvoiceItem item : items) {
            sum += item.getPrice() * item.getQty();
        }
        if (sum > 1000) {
            sum = sum * 0.95;
        }
        return sum * 1.15;
    }

    public String printInvoice() {
        StringBuilder sb = new StringBuilder();
        sb.append("INVOICE ").append(number).append("\n");
        for (InvoiceItem item : items) {
            sb.append(String.format(Locale.US, "%s x%d = %.2f\n",
                    item.getName(), item.getQty(), item.getPrice() * item.getQty()));
        }
        sb.append(String.format(Locale.US, "TOTAL: %.2f", calculateTotal()));
        String text = sb.toString();
        System.out.println(text);
        return text;
    }

    public void saveToDatabase(String type) {
        String line = number + ";" + customerEmail + ";"
                + String.format(Locale.US, "%.2f", calculateTotal());
        if (type.equals("DATABASE")) {
            DATABASE.add(line);
        } else {
            FILES.add(line);
        }
    }

    public String sendEmail() {
        String message = "To: " + customerEmail + "\n"
                + "Subject: Invoice " + number + "\n"
                + printInvoice();
        System.out.println("Sending email...");
        return message;
    }

    public String sendwhatsapp() {
        String message = "To: sendwhatsapp" + "\n"
                + "Subject: Invoice " + number + "\n"
                + printInvoice();
        System.out.println("Sending sendwhatsapp...");
        return message;
    }
}