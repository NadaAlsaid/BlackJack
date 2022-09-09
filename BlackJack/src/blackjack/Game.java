package blackjack;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private static int highScore = 0  ;
    int validScore = 0;
    static ArrayList <Card>  cards = new ArrayList (52);
    Player [] players  = new Player[4];
    Random rand = new Random();
    int randomChoice;
    static  int counter_cards ;
    int counter_card = 53;
// To generate cards
     void  generate() {
         int n = 0;
        for(int suit =0 ; suit < 4 ; suit++) {
            for(int rank = n  ; rank < n+13 ; rank++) {
                if (rank > (n+8)) {
                     cards.add(new Card (suit , rank%13 , 10));
                } else {
                    cards.add( new Card (suit , rank %13, rank%13 + 1));
                }

            }
            n+=13;
        }
    }

    // set information to players
    void information(){
        Scanner in = new Scanner(System.in);
        System.out.println("name of player 1 : ");
        player(0,in.next()  ) ;
        System.out.println("name of player 2 : ");
        player(1,in.next()  ) ;
        System.out.println("name of player 3 : ");
        player(2,in.next()  ) ;
        player(3 ,"dealer" ) ;
    }

    public int getHighScore() {
        return highScore;
    }

    public  void setHighScore(int HighScore) {
         highScore = HighScore;
    }

// TO give 2 random cards for each player
    void player (int index , String name ){
        players[index] = new Player( name , 0  );
        counter_cards =0;
        while (counter_cards<2) {
            randomChoice = rand.nextInt(--counter_card);
            if (cards.get(randomChoice) != null) {
                players[index].setScore(cards.get(randomChoice).getValue());
                players[index].card[counter_cards++]= new Card (cards.get(randomChoice) );
                cards.remove(randomChoice);
            }
        }
        if(index <3) {
            validScore=getHighScore() ;
            if (validScore < players[index].getScore()) {
                setHighScore(players[index].getScore());
            }
        }
    }

// To add cards for player if pressed 1 (Hit)
    Card add_card ( int index , int counter ){
        while(true) {
            randomChoice = rand.nextInt(--counter_card);
            if (cards.get(randomChoice) != null) {
                players[index].setScore(cards.get(randomChoice).getValue());
                players[index].card[counter] = new Card(cards.get(randomChoice));
                cards.remove(randomChoice);
                if (index < 3) {
                    validScore = getHighScore() ;
                    if (validScore < players[index].getScore() && players[index].getScore() <= 21) {
                        setHighScore(players[index].getScore());
                    }

                }
                break;
            }
        }

        return  players[index].card[(counter)]  ;
    }


}
