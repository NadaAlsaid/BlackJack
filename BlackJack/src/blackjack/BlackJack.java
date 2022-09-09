package blackjack;

import java.util.Scanner;

public class BlackJack {
    static Game game = new Game() ;
    static Card [] card = new Card[52] ;

    public static void main(String[] args) {
        GUI gui = new GUI();
        game.generate();
        game.information();
        gui.runGUI(  Game.cards.toArray(card) , game.players[0].card, game.players[1].card, game.players[2].card,game.players[3].card );
        hitOrStand(gui);
        win(gui);

        //       TO show the rest of cards in console
        // for(int i =0 ; i< game.cards.size() ; i++)
          //System.out.println(game.cards.get(i).getSuit() + "    " + game.cards.get(i).getRank() + "     " + game.cards.get(i).getValue());

    }

    //To check HIT or STAND
    static void hitOrStand(GUI gui) {
        int loop = 0;
        String choice;
        Scanner in = new Scanner(System.in);
        do {
            int counter = 3 ;
            System.out.println(game.players[loop].getName() + "  " + game.players[loop].getScore());
            while (true) {
                if (game.players[loop].getScore() > 21) {
                    System.out.println("BUSTED");
                    System.out.println("your score " + game.players[loop].getScore());
                    break;
                } else {
                    System.out.printf("1) HIT %n2) STANDG%n");
                    choice = in.next();
                    if (choice.equals("1")) {
                        gui.updatePlayerHand(game.add_card(loop , counter), loop);
                    } else if (choice.equals("2")) {
                        System.out.println("your score " + game.players[loop].getScore());
                        break;
                    } else {
                        System.out.println("You should choose 1 or 2 ");
                    }
                }
                counter++ ;
            }
            loop++;
        } while (loop < 3);
    }

    // To check who win
    static void win(GUI gui){
        int counter =0 ;
        int counter_card =3 ;
        String name ="";
        System.out.println("Dealer score " + game.players[3].getScore());
        if(winDealer()) {

            gui.updateDealer(Game.cards);
            System.out.println("The dealer WINs");
        }else {
            while (true) {
                card = new Card[Game.cards.size()];
                gui.updateDealerHand(game.add_card(3 , counter_card++), Game.cards.toArray(card));
                System.out.println("Dealer score " + game.players[3].getScore());
                if (game.players[3].getScore() > 21) {
                    System.out.println("BUSTED");
                    for (int index = 0; index < 3; index++) {
                        if (game.players[index].getScore() == game.getHighScore() ) {
                            counter++;
                            name = game.players[index].getName() ;
                        }
                    }
                    if (counter > 1) {
                        System.out.println("PUSH");
                    }else if(counter == 1){
                        System.out.println( name + " wins");
                    }
                    break;
                } else if (game.players[3].getScore() > game.getHighScore()) {
                    System.out.println("The dealer WINs");
                    break;

                } else if (game.players[3].getScore() == game.getHighScore() && game.players[3].getScore() == 21) {
                    System.out.println("PUSH");
                    break;
                }
            }
        }
    }

    // To check if dealer win without need to add card
    static boolean winDealer (){
        int counter =0;
        for (int index = 0; index < 3; index++) {
            if (game.players[index].getScore() == game.getHighScore()) {
                counter++;
            }
        }
        if(counter == 0)
            return true;
        return false ;
    }
}
