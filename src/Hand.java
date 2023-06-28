public class Hand extends Pile{
    private int reshuffles;
    private final Card[] hand;
    private int cardsInHand;

    public Hand() {
        this.hand = new Card[52];
        this.cardsInHand = 0;
        this.cardsInPile = 0;
        this.reshuffles = 0;
    }

    public void addCardToHand(Card card) {
        if(card == null){
            return;
        }
        hand[cardsInHand] = card;
        cardsInHand++;
    }

    public void replenish(){
        if(cardsInHand > 0){
            return;
        }
        reshuffles++;
        // shuffle the pile of cards before adding it back to the hand
        for (int i = 0; i < cardsInPile; i++) {
            int j = (int) (Math.random() * cardsInPile);
            Card temp = pile[i];
            pile[i] = pile[j];
            pile[j] = temp;
        }
        for(int i = 0; i < cardsInPile; i++){
            addCardToHand(pile[i]);
        }
        cardsInPile = 0;
    }

    public Card playCard() {
        replenish();
        if(cardsInHand == 0){
            return null;
        }
        cardsInHand--;
        return hand[cardsInHand];
    }

    public Card[] playWar() {
        if(cardsInHand + cardsInPile <= 1) {
            return null;
        } else if(cardsInHand + cardsInPile < 4){
            Card[] cards = new Card[cardsInHand + cardsInPile - 1];
            for(int i = 0; i < cardsInHand + cardsInPile - 1; i++){
                cards[i] = playCard();
            }
            return cards;
        }
        else {
            Card[] cards = new Card[3];
            for(int i = 0; i < 3; i++){
                cards[i] = playCard();
            }
            return cards;
        }
    }
    public int getReshuffles() {
        return reshuffles;
    }

    public void reset() {
        this.cardsInHand = 0;
        this.cardsInPile = 0;
        this.reshuffles = 0;
    }
}
