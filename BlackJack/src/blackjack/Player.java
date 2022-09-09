package blackjack;

public class Player  {
    private String name ;
    private int  score = 0 ;
    Card [] card  = new Card[11];

    public Player(String name, int score) {
        this.name = name;
        this.score = score;

    }

    public String getName() {
        return name;
    }

    public void setScore(int score) {
        this.score += score;
    }

    public int getScore() {
        return score;
    }
}
