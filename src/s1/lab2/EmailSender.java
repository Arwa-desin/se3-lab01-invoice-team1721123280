package s1.lab2;

public class EmailSender implements InvoiceSender {
    @Override
    public String send(InvoiceData data, String invoiceText) {
        String message = "To: " + data.getCustomerEmail() + "\n"
                + "Subject: Invoice " + data.getNumber() + "\n"
                + invoiceText;
        System.out.println("Sending email...");
        return message;
    }
}