import java.util.ArrayList;
import java.util.HashMap;

public class YearlyReport {
    ArrayList<Month> year;
    HashMap<String, double[]> statistic;
    String date;
    DateFormatter dateFormatter;

    YearlyReport (ArrayList<Month> year, String date) {
        this.year = year;
        this.date = date;
        dateFormatter = new DateFormatter();
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

            System.out.println(dateFormatter.getMonthName(year.get(i).number) + ": " + (int) (profit.amount - expense.amount));

        }
        System.out.println("Средний доход за все месяцы: " + getRoundedAvr(avrIncome, year.size()/ 2));
        System.out.println("Средний расход за все месяцы: " + getRoundedAvr(avrExpense, year.size()/ 2));
        System.out.println();
    }

    public HashMap<String, double[]> getStatistic () {
        statistic = new HashMap<>();

        for (int i = 0; i < year.size(); i += 2) {
            Month profit;
            Month expense;

            if (year.get(i).isExpense) {
                expense = year.get(i);
                profit = year.get(i + 1);
            } else {
                expense = year.get(i + 1);
                profit = year.get(i);
            }
            statistic.put(dateFormatter.getMonthName(year.get(i).number), new double[]{expense.amount, profit.amount});
        }
        return statistic;
    }

    private String getRoundedAvr(double value, int entry) {
        return String.format("%.3f", (value / entry));
    }
}
