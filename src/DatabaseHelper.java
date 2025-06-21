
import java.sql.*;

public class DatabaseHelper {
    private static final String DB_URL = "jdbc:sqlite:resources/expense.db";

    public static Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL);
    }

    public static void initDB() {
        String sql = "CREATE TABLE IF NOT EXISTS expenses (" +
                     "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                     "category TEXT NOT NULL," +
                     "amount REAL NOT NULL," +
                     "date TEXT NOT NULL)";
        try (Connection conn = connect(); Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
