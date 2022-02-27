import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ArrayList<Month> year;
    HashMap<String, double[]> statistic;
    String date;

    YearlyReport (ArrayList<Month> year, String date) {
        this.year = year;
        this.date = date;
    }


    public void printInfo() {
        double avrIncome = 0.d;
        double avrExpense = 0.d;
        Month profit;
        Month expense;
        System.out.println("Рассматриваемый год: " + date);
        System.out.println("Прибыль по каждому месяцу:");
        for (int i = 0; i < year.size(); i += 2) {

            if (year.get(i).isExpense) {
                expense = year.get(i);
                profit = year.get(i + 1);
            } else {
                expense = year.get(i + 1);
                profit = year.get(i);
            }

            avrIncome += profit.amount;
            avrExpense += expense.amount;

            System.out.println(getMonthName(year.get(i).number) + ": " + (int) (profit.amount - expense.amount));

        }
        System.out.println("Средний доход за все месяцы: " + getRoundedAvr(avrIncome, year.size()/ 2));
        System.out.println("Средний расход за все месяцы: " + getRoundedAvr(avrExpense, year.size()/ 2));
        System.out.println();
    }

    public HashMap<String, double[]> getStatistic () {
        statistic = new HashMap<>();

        for (int i = 0; i < year.size(); i += 2) {
            String monthName = getMonthName(year.get(i).number);
            Month profit;
            Month expense;

            if (year.get(i).isExpense) {
                expense = year.get(i);
                profit = year.get(i + 1);
            } else {
                expense = year.get(i + 1);
                profit = year.get(i);
            }

            statistic.put(monthName, new double[]{expense.amount, profit.amount});
        }

        return statistic;
    }
    private String getMonthName(String number) {
        String name = "";
        if ("01".equals(number)) {
            name =  "Январь";
        } else if ("02".equals(number)) {
            name = "Февраль";
        } else if ("03".equals(number)) {
            name = "Март";
        } else if ("04".equals(number)) {
            name = "Март";
        } else if ("05".equals(number)) {
            name = "Март";
        } else if ("06".equals(number)) {
            name = "Март";
        } else if ("07".equals(number)) {
            name = "Март";
        } else if ("08".equals(number)) {
            name = "Март";
        } else if ("09".equals(number)) {
            name = "Март";
        } else if ("10".equals(number)) {
            name = "Март";
        } else if ("11".equals(number)) {
            name = "Март";
        } else if ("12".equals(number)) {
            name = "Март";
        }
        return name;
    }

    private String getRoundedAvr(double value, int entry) {
        return String.format("%.3f", (value / entry));
    }
}
