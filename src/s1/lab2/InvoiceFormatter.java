package s1.lab2;

import java.util.Locale;

public class InvoiceFormatter {
    public String format(InvoiceData data, double total) {
        StringBuilder sb = new StringBuilder();
        sb.append("INVOICE ").append(data.getNumber()).append("\n");
        for (InvoiceItem item : data.getItems()) {
            sb.append(String.format(Locale.US, "%s x%d = %.2f\n",
                    item.getName(), item.getQty(), item.getPrice() * item.getQty()));
        }
        sb.append(String.format(Locale.US, "TOTAL: %.2f", total));
        return sb.toString();
    }

    public String formatRecord(InvoiceData data, double total) {
        return data.getNumber() + ";" + data.getCustomerEmail() + ";"
                + String.format(Locale.US, "%.2f", total);
    }
}