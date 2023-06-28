public class Game {
    private int rounds;
    private int wars;

    private final Deck deck;

    private final Hand player1;
    private final Hand player2;

    private final Pile warPile;

    private boolean inWar;
    private boolean gameOver;

    public Game() {
        this.deck = new Deck();
        this.player1 = new Hand();
        this.player2 = new Hand();
        for (int i = 0; i < 26; i++) {
            player1.addCardToHand(deck.draw());
            player2.addCardToHand(deck.draw());
        }
        this.inWar = false;
        this.warPile = new Pile();
        this.wars = 0;
        this.rounds = 0;
    }

    public void playRound() {
        Card player1Card = player1.playCard();
        Card player2Card = player2.playCard();
        if(player1Card == null || player2Card == null){
            gameOver = true;
            return;
        }
        if(player1Card.getRank() > player2Card.getRank()) {
            player1.addCardToPile(player1Card);
            player1.addCardToPile(player2Card);
            if(inWar){
                player1.addCardToPile(warPile.emptyPile());
                inWar = false;
            }
        } else if (player2Card.getRank() > player1Card.getRank()) {
            player2.addCardToPile(player1Card);
            player2.addCardToPile(player2Card);
            if(inWar){
                player2.addCardToPile(warPile.emptyPile());
                inWar = false;
            }
        } else {
            wars++;
            inWar = true;
            warPile.addCardToPile(player1Card);
            warPile.addCardToPile(player2Card);
            war();
            return;
        }
        rounds++;
    }

    public void war() {
        Card[] player1Cards = player1.playWar();
        Card[] player2Cards = player2.playWar();
        if(player1Cards != null) {
            warPile.addCardToPile(player1Cards);
        }
        if(player2Cards != null) {
            warPile.addCardToPile(player2Cards);
        }
        playRound();
    }

    public int[] startGame() {
        reset();
        while(!gameOver) {
            playRound();
            if(rounds > 1000000000){
                System.out.println("Game took too long, exiting...");
                return new int[]{rounds, wars, player1.getReshuffles() + player2.getReshuffles()};
            }
        }
        return new int[]{rounds, wars, player1.getReshuffles() + player2.getReshuffles()};
    }

    public void reset() {
        this.rounds = 0;
        this.wars = 0;
        this.gameOver = false;
        this.inWar = false;
        this.deck.shuffle();
        this.player1.reset();
        this.player2.reset();
        this.warPile.emptyPile();
        for (int i = 0; i < 26; i++) {
            player1.addCardToHand(deck.draw());
            player2.addCardToHand(deck.draw());
        }
    }

}
