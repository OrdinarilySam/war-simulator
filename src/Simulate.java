public class Simulate {
    public static void main(String[] args) {
        int rounds = 1000000;
        int secondsInRound = 2;
        int secondsInWar = 10;
        int secondsInReshuffle = 10;

        long roundsSum = 0L;
        long warsSum = 0L;
        long reshufflesSum = 0L;
        Game game = new Game();
        for(int i = 0; i < rounds; i++){
            int[] result = game.startGame();
            roundsSum += result[0];
            warsSum += result[1];
            reshufflesSum += result[2];
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
        System.out.println("Average time spent per round: " + (float) timeSpent / 60 + " minutes");
    }
}
