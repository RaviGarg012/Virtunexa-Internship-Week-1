# Expense & Fibonacci Java App

## Features:
- Generate Fibonacci series up to a user-defined number.
- Add, view, and delete categorized expenses.
- Uses SQLite for local data storage.

## Requirements:
- Java 8+
- SQLite JDBC Driver

## Run:
```bash
java -cp ".:lib/sqlite-jdbc-<version>.jar" -jar ExpenseFibonacciApp.jar
```

## Structure:
- CLI-based interface
- SQLite DB under `resources/expense.db`
