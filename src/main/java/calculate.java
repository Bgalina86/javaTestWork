import validation.evaluate;

import java.util.Scanner;

public class calculate extends evaluate {
    private static double prevResult = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Enter expression (or 'q' to exit): ");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("q")) {
                break;
            }
            if (input.charAt(0) == '+' || input.charAt(0) == '-' || input.charAt(0) == '*' || input.charAt(0) == '/') {
                input = prevResult + input;
            }
            prevResult = (double) evaluate(input);
            System.out.println("Result: " + prevResult);
        }
        sc.close();
    }
}
