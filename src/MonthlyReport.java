import java.util.ArrayList;
import java.util.HashMap;

public class MonthlyReport {
    HashMap<String, ArrayList<Category>> months;
    HashMap<String, double[]> statistic;

    MonthlyReport (HashMap<String, ArrayList<Category>> months) {
        this.months = months;
    }

    public void printInfo() {

        for (String monthNum : months.keySet()) {
            int maxProfit = 0;
            String maxProfitName = "";

            int maxExpense = 0;
            String maxExpenseName = "";
            System.out.println("Название месяца: " + getMonthName(Integer.parseInt(monthNum)));

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
            String monthName = getMonthName(Integer.parseInt(monthNum));
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

    private String getMonthName (int monthNum) {
        if (monthNum == 1) {
            return "Январь";
        } else if (monthNum == 2) {
            return "Февраль";
        } else if (monthNum == 3) {
            return "Март";
        } else if (monthNum == 4) {
            return "Апрель";
        } else if (monthNum == 5) {
            return "Май";
        } else if (monthNum == 6) {
            return "Июнь";
        } else if (monthNum == 7) {
            return "Июль";
        } else if (monthNum == 8) {
            return "Август";
        } else if (monthNum == 9) {
            return "Сентябрь";
        } else if (monthNum == 10) {
            return "Октябрь";
        } else if (monthNum == 11) {
            return "Ноябрь";
        } else if (monthNum == 12) {
            return "Декабрь";
        }
        return "";
    }
}
