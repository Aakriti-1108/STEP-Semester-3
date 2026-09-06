package OOPFundamental.assignment_problems;

import java.util.Arrays;

public class Player implements Comparable<Player> {

    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    // Experience-only rule
    static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    // Combined matches and fitness rule
    static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    @Override
    public int compareTo(Player other) {
        return Double.compare(
                other.battingAverage,
                this.battingAverage
        );
    }

    static String draftAndRank(Player[] players) {

        Player[] draftable = new Player[players.length];

        int count = 0;

        for (Player player : players) {

            if (isDraftable(player.matchesPlayed) ||
                    isDraftable(player.matchesPlayed, player.injured)) {

                draftable[count] = player;
                count++;
            }
        }

        draftable = Arrays.copyOf(draftable, count);

        Arrays.sort(draftable);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < draftable.length; i++) {

            result.append(i + 1)
                    .append(". ")
                    .append(draftable[i].name);

            if (i < draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Player[] players = {
                new Player("Virat", 15, 48.0, false),
                new Player("Rahul", 7, 55.0, false),
                new Player("Sameer", 3, 60.0, false),
                new Player("Dev", 12, 20.0, true)
        };

        System.out.println(draftAndRank(players));
    }
}