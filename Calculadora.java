
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculadora {

    enum OperatorType {
        ADD("+"),
        SUBTRACT("-"),
        MULTIPLY("*"),
        DIVIDE("/"),
        REMAINDER("%"),
        POWER("^");

        private final String value;

        OperatorType(String value) {
            this.value = value;
        }

        public String getSymbol() {
            return switch (value) {
                case "*" -> "×";
                case "/" -> "÷";
                default -> value;
            };
        }

        public String getValue() {
            return value;
        }

        public static OperatorType fromString(String operator) {
            for (OperatorType button : OperatorType.values()) {
                if (button.getValue().equals(operator) || button.name().equalsIgnoreCase(operator)) {
                    return button;
                }
            }
            throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    private static Double perform(OperatorType operator, Double first, Double second) {
        return switch (operator) {
            case ADD -> first + second;
            case SUBTRACT -> first - second;
            case MULTIPLY -> first * second;
            case DIVIDE -> second == 0.0 ? Double.NaN : first / second;
            case REMAINDER -> first % second;
            case POWER -> Math.pow(first, second);
        };
    }

    private static double readNumber(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid number. Please enter a valid number.");
                scanner.next(); 
            }
        }
    }

    private static OperatorType readOperator(Scanner scanner) {
        while (true) {
            System.out.println("(ADD(+), SUBTRACT(-), MULTIPLY(*), DIVIDE(/), REMAINDER(%), POWER(^))");
            System.out.print("Enter the operator: ");
            String operatorInput = scanner.next();
            try {
                return OperatorType.fromString(operatorInput);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the first number: ");
            double firstNumber = readNumber(scanner);

            System.out.print("Enter the second number: ");
            double secondNumber = readNumber(scanner);

            OperatorType operator = readOperator(scanner);

            double result = perform(operator, firstNumber, secondNumber);
            System.out.println("Input: " + firstNumber + " " + operator.getSymbol() + " " + secondNumber);
            System.out.println("Result: " + result);
        }
    }
}
