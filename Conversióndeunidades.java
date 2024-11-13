
import java.util.Scanner;

public class Conversióndeunidades {
    private static final double EURO_TO_DOLLAR_RATE = 1.07;
    private static final double DOLLAR_TO_EURO_RATE = 0.94;

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int option = getConversionOption(scanner);
            double value = getValue(scanner, option);
            double result = performConversion(option, value);

            displayResult(option, value, result);
        }
    }

    private static int getConversionOption(Scanner scanner) {
        System.out.println("Seleccione una conversión:");
        System.out.println(" [1]. Celsius a Fahrenheit");
        System.out.println(" [2]. Fahrenheit a Celsius");
        System.out.println(" [3]. Euros a Dólares");
        System.out.println(" [4]. Dólares a Euros");

        System.out.print("Ingrese el número de la conversión que desea realizar: ");
        return scanner.nextInt();
    }

    private static double getValue(Scanner scanner, int option) {
        System.out.print("Ingrese el valor en " + getUnitName(option) + ": ");
        return scanner.nextDouble();
    }

    private static String getUnitName(int option) {
        return switch (option) {
            case 1 -> "Celsius";
            case 2 -> "Fahrenheit";
            case 3 -> "Euros";
            case 4 -> "Dólares";
            default -> "valor";
        };
    }

    private static double performConversion(int option, double value) {
        return switch (option) {
            case 1 -> celsiusToFahrenheit(value);
            case 2 -> fahrenheitToCelsius(value);
            case 3 -> eurosToDollars(value);
            case 4 -> dollarsToEuros(value);
            default -> throw new IllegalArgumentException("Opción no válida.");
        };
    }

    private static void displayResult(int option, double value, double result) {
        switch (option) {
            case 1:
                System.out.printf("%.2f Celsius son %.2f Fahrenheit.%n", value, result);
                break;
            case 2:
                System.out.printf("%.2f Fahrenheit son %.2f Celsius.%n", value, result);
                break;
            case 3:
                System.out.printf("%.2f Euros son %.2f Dólares.%n", value, result);
                break;
            case 4:
                System.out.printf("%.2f Dólares son %.2f Euros.%n", value, result);
                break;
            default:
                System.out.println("Opción no válida. Por favor, seleccione una opción entre 1 y 4.");
        }
    }

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }

    public static double eurosToDollars(double euros) {
        return euros * EURO_TO_DOLLAR_RATE;
    }

    public static double dollarsToEuros(double dollars) {
        return dollars * DOLLAR_TO_EURO_RATE;
    }
}