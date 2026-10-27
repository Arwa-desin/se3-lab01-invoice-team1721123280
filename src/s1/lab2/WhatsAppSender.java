package s1.lab2;

public class WhatsAppSender implements InvoiceSender {
    @Override
    public String send(InvoiceData data, String invoiceText) {
        String message = "To: sendwhatsapp" + "\n"
                + "Subject: Invoice " + data.getNumber() + "\n"
                + invoiceText;
        System.out.println("Sending sendwhatsapp...");
        return message;
    }
}