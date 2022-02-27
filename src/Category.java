public class Category {
    String name;
    boolean isExpense;
    int quantity;
    double sumOfOne;

    Category (String name, boolean isExpense, int quantity, double sumOfOne) {
        this.name = name;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
