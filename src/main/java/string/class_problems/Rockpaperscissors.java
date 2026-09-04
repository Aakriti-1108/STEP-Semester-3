package string.class_problems;
import java.util.*;
import java.util.Scanner;
public class Rockpaperscissors {

        static String playRound(String playerMove, String computerMove) {
            if (playerMove.equals(computerMove)) {
                return "Draw";
            }

            if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
                    (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
                    (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
                return "Player Wins";
            }

            return "Computer Wins";
        }

        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            Random random = new Random();

            String[] moves = {"Rock", "Paper", "Scissors"};

            String[][] results = new String[5][3];

            int wins = 0, losses = 0, draws = 0;

            for (int i = 0; i < 5; i++) {

                System.out.println("\nRound " + (i + 1));
                System.out.print("Enter your move (Rock/Paper/Scissors): ");
                String playerMove = sc.next();

                // Convert first letter to uppercase and remaining to lowercase
                playerMove = playerMove.substring(0, 1).toUpperCase()
                        + playerMove.substring(1).toLowerCase();

                String computerMove = moves[random.nextInt(3)];

                String result = playRound(playerMove, computerMove);

                System.out.println("Player: " + playerMove);
                System.out.println("Computer: " + computerMove);
                System.out.println("Result: " + result);

                results[i][0] = playerMove;
                results[i][1] = computerMove;
                results[i][2] = result;

                if (result.equals("Player Wins"))
                    wins++;
                else if (result.equals("Computer Wins"))
                    losses++;
                else
                    draws++;
            }

            double winPercentage = (wins / 5.0) * 100;

            System.out.println("\n========== FINAL SUMMARY ==========");
            System.out.printf("%-8s %-15s %-15s %-18s%n",
                    "Round", "Player Move", "Computer Move", "Result");

            for (int i = 0; i < 5; i++) {
                System.out.printf("%-8d %-15s %-15s %-18s%n",
                        i + 1, results[i][0], results[i][1], results[i][2]);
            }

            System.out.println("\nWins: " + wins);
            System.out.println("Losses: " + losses);
            System.out.println("Draws: " + draws);
            System.out.printf("Win Percentage: %.1f%%%n", winPercentage);

            sc.close();
        }
    }

