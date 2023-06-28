public class Simulate {
    public static void main(String[] args) {
        int rounds = 1000000;
        int secondsInRound = 2;
        int secondsInWar = 10;
        int secondsInReshuffle = 10;

        long roundsSum = 0L;
        long warsSum = 0L;
        long reshufflesSum = 0L;

        int longestGame = 0;
        int shortestGame = Integer.MAX_VALUE;
        Game game = new Game();
        for(int i = 0; i < rounds; i++){
            int[] result = game.startGame();
            roundsSum += result[0];
            warsSum += result[1];
            reshufflesSum += result[2];
            int timeInSec = (result[0] * secondsInRound)
                    + (result[1] * secondsInWar)
                    + (result[2] * secondsInReshuffle);
            longestGame = Math.max(longestGame, timeInSec);
            shortestGame = Math.min(shortestGame, timeInSec);
        }

        int avgRounds = (int) roundsSum/rounds;
        int avgWars = (int) warsSum/rounds;
        int avgReshuffles = (int) reshufflesSum/rounds;

        int timeSpent = (avgRounds * secondsInRound)
                + (avgWars * secondsInWar)
                + (avgReshuffles * secondsInReshuffle);

        System.out.println("Average number of rounds: " + avgRounds);
        System.out.println("Average number of wars: " + avgWars);
        System.out.println("Average number of reshuffles: " + avgReshuffles);
        System.out.println();
        System.out.println("Average time spent per round: " + (float) timeSpent / 60 + " minutes");
        System.out.println("Longest game: " + (float) longestGame / 60 + " minutes");
        System.out.println("Shortest game: " + (float) shortestGame / 60 + " minutes");
    }
}
