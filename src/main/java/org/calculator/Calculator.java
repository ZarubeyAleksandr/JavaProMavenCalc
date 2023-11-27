package org.calculator;

public class Calculator {

    private static double calculate(double operand1, String operator, double operand2) {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "x" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero is not allowed.");
                }
                yield operand1 / operand2;
            }
            default -> throw new IllegalArgumentException("Invalid operator. Supported operators are +, -, x, /.");
        };
    }
    public static void main(String[] args) {
        //System.out.println(args.length);
        if (args.length != 3) {
            System.out.println("Usage: java -jar Calculator.jar <operand1> <operator> <operand2>");
            System.exit(1);
        }

        try {
            double operand1 = Double.parseDouble(args[0]);
            double operand2 = Double.parseDouble(args[2]);
            String operator = args[1];

            double result = calculate(operand1, operator, operand2);
            System.out.println("Result: " + result);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter valid numeric values.");
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
