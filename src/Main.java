
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DatabaseHelper.initDB();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Generate Fibonacci Series");
            System.out.println("2. Add Expense");
            System.out.println("3. View Expenses");
            System.out.println("4. Delete Expense");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = sc.nextInt();
            sc.nextLine(); // flush

            switch (choice) {
                case 1:
                    System.out.print("Enter limit: ");
                    int limit = sc.nextInt();
                    FibonacciGenerator.generateSeries(limit);
                    break;
                case 2:
                    System.out.print("Category: ");
                    String category = sc.nextLine();
                    System.out.print("Amount: ");
                    double amount = sc.nextDouble();
                    sc.nextLine(); // flush
                    System.out.print("Date (YYYY-MM-DD): ");
                    String date = sc.nextLine();
                    ExpenseManager.addExpense(category, amount, date);
                    break;
                case 3:
                    ExpenseManager.listExpenses();
                    break;
                case 4:
                    System.out.print("Enter Expense ID to delete: ");
                    int id = sc.nextInt();
                    ExpenseManager.deleteExpense(id);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
