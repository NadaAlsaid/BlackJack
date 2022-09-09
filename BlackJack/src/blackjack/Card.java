package blackjack;

public class Card {
     private final int  rank;
     private final int  value ;
     private final int  suit  ;


    public Card(int suit , int rank , int value) {
        this.value = value;
        this.suit = suit;
        this.rank = rank;
    }
    public Card (Card  card) {
        this.suit = card.suit;
        this.value = card.value;
        this.rank = card.rank;
    }

    public  int getRank() {
        return  rank;
    }

    public int getValue() {
        return value;
    }

    public int getSuit() {
        return suit;
    }

}
