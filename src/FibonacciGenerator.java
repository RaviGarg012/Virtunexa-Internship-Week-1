
import java.util.Scanner;

public class FibonacciGenerator {
    public static void generateSeries(int limit) {
        int a = 0, b = 1;
        System.out.print("Fibonacci Series up to " + limit + ": ");
        while (a <= limit) {
            System.out.print(a + " ");
            int temp = a + b;
            a = b;
            b = temp;
        }
        System.out.println();
    }
}
