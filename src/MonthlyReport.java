import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<String, ArrayList<Category>> months;
    HashMap<String, double[]> statistic;
    DateFormatter dateFormatter;

    MonthlyReport (HashMap<String, ArrayList<Category>> months) {
        this.months = months;
        dateFormatter = new DateFormatter();
    }

    public void printInfo() {

        for (String monthNum : months.keySet()) {
            int maxProfit = 0;
            String maxProfitName = "";

            int maxExpense = 0;
            String maxExpenseName = "";
            System.out.println("Название месяца: " + dateFormatter.getMonthName(monthNum));

            for(Category category : months.get(monthNum)) {
                int amount = (int) (category.quantity * category.sumOfOne);
                if (category.isExpense) {
                    if (amount > maxExpense) {
                        maxExpense = amount;
                        maxExpenseName = category.name;
                    }
                } else {
                    if (amount > maxProfit) {
                        maxProfit = amount;
                        maxProfitName = category.name;
                    }
                }
            }
            System.out.println("Самый прибыльный товар: " + maxProfitName + ", " + maxProfit);
            System.out.println("Самая больша трата: " + maxExpenseName + ", " + maxExpense);
            System.out.println();
        }
    }

    public HashMap<String, double[]> getStatistic() {
        statistic = new HashMap<>();
        for (String monthNum : months.keySet()) {
            String monthName = dateFormatter.getMonthName(monthNum);
            double expenseSum = 0.0;
            double profitSum = 0.0;

            for (Category category : months.get(monthNum)) {
                if (category.isExpense) {
                    expenseSum += category.sumOfOne * category.quantity;
                } else {
                    profitSum += category.sumOfOne * category.quantity;
                }
            }
            statistic.put(monthName, new double[]{expenseSum, profitSum});
        }
        return statistic;
    }
}
