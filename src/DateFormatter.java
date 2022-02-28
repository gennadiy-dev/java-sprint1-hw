import java.util.HashMap;

public class DateFormatter {
    HashMap<Integer, String> monthsMap;

    DateFormatter () {
        monthsMap = new HashMap<>();
        monthsMap.put(1, "Январь");
        monthsMap.put(2, "Февраль");
        monthsMap.put(3, "Март");
        monthsMap.put(4, "Апрель");
        monthsMap.put(5, "Май");
        monthsMap.put(6, "Июнь");
        monthsMap.put(7, "Июль");
        monthsMap.put(8, "Август");
        monthsMap.put(9, "Сентябрь");
        monthsMap.put(10, "Октябрь");
        monthsMap.put(11, "Ноябрь");
        monthsMap.put(12, "Декабрь");
    }

    public String getMonthName(String monthStr) {
        int monthNumber = Integer.parseInt(monthStr);
        return monthsMap.get(monthNumber);
    }
}
