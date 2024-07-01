import java.util.Random;
import java.util.Scanner;

public class CrapsGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        boolean playAgain = true;

        while (playAgain) {
            System.out.println("Welcome to Craps! Rolling the dice...");
            int firstRoll = rollDice(random);

            if (firstRoll == 2 || firstRoll == 3 || firstRoll == 12) {
                System.out.println("Craps! You lose.");
            } else if (firstRoll == 7 || firstRoll == 11) {
                System.out.println("Natural! You win.");
            } else {
                int point = firstRoll;
                System.out.println("Your point is " + point + ". Keep rolling to make your point.");
                boolean rolling = true;
                while (rolling) {
                    int newRoll = rollDice(random);
                    if (newRoll == 7) {
                        System.out.println("You rolled a 7. You lose.");
                        rolling = false;
                    } else if (newRoll == point) {
                        System.out.println("You made your point! You win.");
                        rolling = false;
                    } else {
                        System.out.println("Trying for point " + point + ". Roll again.");
                    }
                }
            }

            System.out.print("Do you want to play again? (yes/no): ");
            String response = scanner.nextLine();
            playAgain = response.equalsIgnoreCase("yes");
        }

        System.out.println("Thanks for playing Craps!");
    }

    private static int rollDice(Random random) {
        int die1 = random.nextInt(6) + 1;
        int die2 = random.nextInt(6) + 1;
        int sum = die1 + die2;
        System.out.println("Die 1: " + die1 + ", Die 2: " + die2 + ", Sum: " + sum);
        return sum;
    }
}
