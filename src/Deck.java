public class Deck {
    private final Card[] deck;
    private int cardsLeft;

    public Deck() {
        Card[] newDeck = new Card[52];
        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 13; j++){
                newDeck[(i*13) + j] = new Card(j + 1);
            }
        }
        this.deck = newDeck;
        this.cardsLeft = 52;
        this.shuffle();
    }

    public void shuffle() {
        for (int i = 0; i < 52; i++) {
            int j = (int) (Math.random() * 52);
            Card temp = deck[i];
            deck[i] = deck[j];
            deck[j] = temp;
        }
        cardsLeft = 52;
    }

    public Card draw() {
        cardsLeft--;
        return deck[cardsLeft];
    }
}
