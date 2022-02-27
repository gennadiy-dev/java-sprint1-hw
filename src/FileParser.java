import java.util.ArrayList;
import java.util.HashMap;

public class FileParser {
    ArrayList<Month> year;
    ArrayList<Category> items;
    HashMap<String, ArrayList<Category>> months;

    String rowSeparator;
    String valueSeparator;

    FileParser (String rowSeparator, String valueSeparator) {
        this.rowSeparator = rowSeparator;
        this.valueSeparator = valueSeparator;
    }

    public ArrayList<Month> parseYear (String data) {
        this.year = new ArrayList<>();
        String[] rows = data.split(rowSeparator);
        for (int i = 1; i < rows.length; i++) {
            String[] values = rows[i].split(",");
            String name = values[0];
            double amount = Integer.parseInt(values[1]);
            boolean isExpense = "true".equals(values[2].trim());
            this.year.add(new Month(name, amount, isExpense));
        }
        return year;
    }

    public HashMap<String, ArrayList<Category>> parseMonths (String[] dataList) {
        months = new HashMap<>();
        for (int i = 0; i < dataList.length; i++) {
            String[] rows = dataList[i].split(rowSeparator);
            this.items = new ArrayList<>();
            for (int j = 1; j < rows.length; j++) {
                String[] values = rows[j].split(",");
                String name = values[0];
                boolean isExpense = "true".equals(values[1].trim().toLowerCase());
                int quantity = Integer.parseInt(values[2].trim());
                double sumOfOne = Double.parseDouble(values[3]);
                items.add(new Category(name, isExpense,quantity, sumOfOne));
            }
            months.put(Integer.toString(i + 1), items);
        }
        return months;
    }
}
