import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String date = "2021";
        String path = "./resources";

        String rowSeparator = "\\n";
        String valueSeparator = ",";
        int monthCount = 3;

        String[] dataList;
        String data;

        FileReader reader = new FileReader(path, date, monthCount);
        FileParser parser = new FileParser(rowSeparator, valueSeparator);

        HashMap<String, ArrayList<Category>> months;
        ArrayList<Month> year;

        MonthlyReport monthlyReport = null;
        YearlyReport yearlyReport = null;

        HashMap<String, double[]> monthlyStatistic;
        HashMap<String, double[]> yearStatistic;

        while (true) {
            printMenu();
            int command = sc.nextInt();
            if (command == 1) {
                dataList = reader.readMonthFiles(); // +
                months = parser.parseMonths(dataList); // +
                monthlyReport = new MonthlyReport(months);
            } else if (command == 2) {
                data = reader.readYearFile(); // +
                year = parser.parseYear(data); // +
                yearlyReport = new YearlyReport(year, date);
            } else if (command == 3) {
                if (monthlyReport != null && yearlyReport != null) {
                    monthlyStatistic = monthlyReport.getStatistic();
                    yearStatistic = yearlyReport.getStatistic();
                    compareReports(monthlyStatistic, yearStatistic);
                } else {
                    System.out.println("Ошибка, не считаны необходимые отчеты");
                }
            } else if (command == 4) {
                if (monthlyReport != null) {
                    monthlyReport.printInfo();
                } else {
                    System.out.println("Не считаны месячные отчеты");
                }
            } else if (command == 5) {
                if (yearlyReport != null) {
                    yearlyReport.printInfo();
                } else {
                    System.out.println("Не считан годовой отчет");
                }
            } else if (command == 0) {
                System.out.println("Выход");
                return;
            } else {
                System.out.println("Извините, такой команды нет.");
            }
        }

    }

    public static void compareReports (HashMap<String, double[]> monthlyStatistic,
                                       HashMap<String, double[]> yearStatistic) {
        boolean isOk = true;
        for (String month : yearStatistic.keySet()) {
            double[] valuesYear = yearStatistic.get(month);
            double[] valuesMonth = monthlyStatistic.get(month);

            if (valuesYear[0] != valuesMonth[0] || valuesYear[1] != valuesMonth[1]) {
                isOk = false;
                System.out.println(month + ": ошибка");
            }
        }
        if (isOk) {
            System.out.println("Операция успешно завершена");
        }
    }

    public static void printMenu() {
        System.out.println("Что вы хотите сделать?");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("0 - Выход");
    }
}