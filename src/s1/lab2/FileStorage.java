package s1.lab2;

import java.util.ArrayList;
import java.util.List;

public class FileStorage implements InvoiceStorage {
    private final List<String> records = new ArrayList<>();

    @Override
    public void save(String record) {
        records.add(record);
    }

    public List<String> getRecords() {
        return records;
    }
}