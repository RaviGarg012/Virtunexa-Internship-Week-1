
import java.sql.*;

public class ExpenseManager {
    public static void addExpense(String category, double amount, String date) {
        String sql = "INSERT INTO expenses (category, amount, date) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, category);
            pstmt.setDouble(2, amount);
            pstmt.setString(3, date);
            pstmt.executeUpdate();
            System.out.println("Expense added successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void listExpenses() {
        String sql = "SELECT * FROM expenses";
        try (Connection conn = DatabaseHelper.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                System.out.printf("ID: %d | Category: %s | Amount: %.2f | Date: %s%n",
                        rs.getInt("id"), rs.getString("category"),
                        rs.getDouble("amount"), rs.getString("date"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteExpense(int id) {
        String sql = "DELETE FROM expenses WHERE id = ?";
        try (Connection conn = DatabaseHelper.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affected = pstmt.executeUpdate();
            if (affected > 0)
                System.out.println("Expense deleted.");
            else
                System.out.println("Expense not found.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
