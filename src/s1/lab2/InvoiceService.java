package s1.lab2;

public class InvoiceService {
    private final InvoiceCalculator calculator;
    private final InvoiceFormatter formatter;
    private final InvoiceStorage storage;
    private final InvoiceSender sender;

    public InvoiceService(InvoiceCalculator calculator, InvoiceFormatter formatter,
                          InvoiceStorage storage, InvoiceSender sender) {
        this.calculator = calculator;
        this.formatter = formatter;
        this.storage = storage;
        this.sender = sender;
    }

    public String print(InvoiceData data) {
        String text = formatter.format(data, calculator.calculateTotal(data));
        System.out.println(text);
        return text;
    }

    public String process(InvoiceData data) {
        double total = calculator.calculateTotal(data);
        storage.save(formatter.formatRecord(data, total));
        String text = print(data);
        return sender.send(data, text);
    }

    public double total(InvoiceData data) {
        return calculator.calculateTotal(data);
    }
}