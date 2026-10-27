package s1.lab2;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        InvoiceCalculator calculator = new InvoiceCalculator();
        InvoiceFormatter formatter = new InvoiceFormatter();

        DatabaseStorage database = new DatabaseStorage();
        FileStorage files = new FileStorage();

        InvoiceService databaseAndEmail =
                new InvoiceService(calculator, formatter, database, new EmailSender());
        InvoiceService filesAndWhatsApp =
                new InvoiceService(calculator, formatter, files, new WhatsAppSender());

        InvoiceData inv1 = new InvoiceData("INV-1", "lina@uni.edu");
        inv1.addItem("Book", 100, 2);
        InvoiceData inv2 = new InvoiceData("INV-2", "omar@uni.edu");
        inv2.addItem("Computer", 1200, 1);
        InvoiceData inv3 = new InvoiceData("INV-3", "sara@uni.edu");
        inv3.addItem("Item", 500, 2);

        InvoiceData[] all = { inv1, inv2, inv3 };
        for (InvoiceData inv : all) {
            System.out.println("=== Processing ===");
            databaseAndEmail.print(inv);
            System.out.println("Total: " + String.format(Locale.US, "%.2f", databaseAndEmail.total(inv)));
            databaseAndEmail.process(inv);
            filesAndWhatsApp.process(inv);
        }

        System.out.println("=== DATABASE ===");
        for (String line : database.getRecords()) System.out.println(line);
        System.out.println("=== FILES ===");
        for (String line : files.getRecords()) System.out.println(line);
    }
}