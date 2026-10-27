package s1.lab1;

import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Invoice inv1 = new Invoice("INV-1", "lina@uni.edu");
        inv1.addItem("Book", 100, 2);

        Invoice inv2 = new Invoice("INV-2", "omar@uni.edu");
        inv2.addItem("Computer", 1200, 1);

        Invoice inv3 = new Invoice("INV-3", "sara@uni.edu");
        inv3.addItem("Item", 500, 2);

        Invoice[] all = { inv1, inv2, inv3 };
        for (Invoice inv : all) {
            System.out.println("=== Processing ===");
            inv.printInvoice();
            System.out.println("Total: " + String.format(Locale.US, "%.2f", inv.calculateTotal()));
            inv.saveToDatabase("DATABASE");
            inv.saveToDatabase("FILES");
            inv.sendEmail();
            inv.sendwhatsapp();
        }

        System.out.println("=== DATABASE ===");
        for (String line : Invoice.DATABASE) System.out.println(line);
        System.out.println("=== FILES ===");
        for (String line : Invoice.FILES) System.out.println(line);
    }
}