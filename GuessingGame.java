import java.util.*;

public class GuessingGame {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);  // Create a scanner object for user input
        int sum = 0;
        int bestGame = Integer.MAX_VALUE;
        int gameCount = 0;
        int ans = 1;

        introduction();
        while (ans == 1) {
            int numberOfTries = playGame(console);
            sum += numberOfTries;
            gameCount++;
            if (numberOfTries < bestGame) {
                bestGame = numberOfTries;
            }
            System.out.print("Do you want to play again? ");
            String answer = console.next();
            if (answer.toLowerCase().startsWith("y")) {
                ans = 1;
            } else {
                ans = 0;
            }
        }
        report(gameCount, sum, bestGame);
        console.close(); // Close the scanner to prevent resource leak
    }

    public static void introduction() {
        System.out.println("\nWelcome to the guessing game!");
        System.out.println("I am thinking of an integer between 1 and 1000.");
        System.out.println("You will have up to 5 tries to guess it.");
        System.out.println("After each try, I will give you a hint: how close are you?");
        System.out.println("If you are close, I will give you a lower number.");
        System.out.println("If you are far off, I will give you a higher number.\n");
    }

    public static int playGame(Scanner console) {
        Random random = new Random();
        int randomNumber = random.nextInt(1000) + 1;
        int numberOfTries = 0;

        while (numberOfTries < 5) {
            numberOfTries++;
            System.out.print("Your guess? ");
            int guess = console.nextInt();

            if (guess == randomNumber) {
                System.out.println("You got it right in " + numberOfTries + " guess" + (numberOfTries == 1 ? "" : "es"));
                break;
            } else if (guess < randomNumber) {
                System.out.println("It's higher.");
            } else {
                System.out.println("It's lower.");
            }
        }
        if (numberOfTries == 5) {
            System.out.println("Sorry, you've used all your tries. The correct number was: " + randomNumber);
        }
        return numberOfTries;
    }

    public static void report(int gameCount, int sum, int bestGame) {
        System.out.println("\nOverall results:");
        System.out.println("    total games = " + gameCount);
        System.out.println("    total guesses = " + sum);
        System.out.printf("    guesses/game = %.1f\n", (double) sum / gameCount);
        System.out.println("    best game = " + bestGame);
    }
}
