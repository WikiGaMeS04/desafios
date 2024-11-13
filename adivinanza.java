
import java.util.Random;
import java.util.Scanner;

public class adivinanza {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 100;

    public static void main(String[] args) {
        int randomNumber = generateRandomNumber();
        playGame(randomNumber);
    }

    private static int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(MAX_NUMBER) + MIN_NUMBER; 
    }

    private static void playGame(int randomNumber) {
        boolean guessed = false;

        System.out.println("¡Bienvenido al juego de adivinanza!");
        System.out.println("Se ha generado un número entre " + MIN_NUMBER + " y " + MAX_NUMBER + ". Intenta adivinarlo.");

       
        try (Scanner scanner = new Scanner(System.in)) {
            while (!guessed) {
                int attempt = getUserInput(scanner);
                guessed = checkGuess(attempt, randomNumber);
            }
        }
    }

    private static int getUserInput(Scanner scanner) {
        int attempt = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Introduce tu intento: ");
            try {
                attempt = scanner.nextInt();
                if (attempt < MIN_NUMBER || attempt > MAX_NUMBER) {
                    System.out.println("Por favor, introduce un número entre " + MIN_NUMBER + " y " + MAX_NUMBER + ".");
                } else {
                    validInput = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Por favor, introduce un número.");
                scanner.next(); 
            }
        }

        return attempt;
    }

    private static boolean checkGuess(int attempt, int randomNumber) {
        if (attempt < randomNumber) {
            System.out.println("El número es mayor. Intenta de nuevo.");
            return false;
        } else if (attempt > randomNumber) {
            System.out.println("El número es menor. Intenta de nuevo.");
            return false;
        } else {
            System.out.println("¡Felicidades! Adivinaste el número: " + randomNumber);
            return true;
        }
    }
}
