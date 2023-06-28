public class Pile {
    protected final Card[] pile;
    protected int cardsInPile;

    public Pile() {
        this.pile = new Card[52];
        this.cardsInPile = 0;
    }

    public void addCardToPile(Card card) {
        if(card == null){
            return;
        }
        pile[cardsInPile] = card;
        cardsInPile++;
    }

    public void addCardToPile(Card[] cards){
        for(Card card : cards){
            addCardToPile(card);
        }
    }

    public Card[] emptyPile() {
        if(cardsInPile == 0){
            return null;
        }
        Card[] cards = new Card[cardsInPile];
        for(int i = 0; i < cardsInPile; i++){
            cards[i] = pile[i];
        }
        cardsInPile = 0;
        return cards;
    }
}
