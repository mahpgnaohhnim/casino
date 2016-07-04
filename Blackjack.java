/**
 * Created by henry on 01.06.16.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Blackjack{

    MenuTools tools = new MenuTools();
    Scanner scan = new Scanner(System.in);

    String[] spade = {"\uD83C\uDCA1", "\uD83C\uDCA2", "\uD83C\uDCA3", "\uD83C\uDCA4", "\uD83C\uDCA5", "\uD83C\uDCA6", "\uD83C\uDCA7", "\uD83C\uDCA8", "\uD83C\uDCA9", "\uD83C\uDCAA", "\uD83C\uDCAB", "\uD83C\uDCAD", "\uD83C\uDCAE", };
    String[] heart = {"\uD83C\uDCB1", "\uD83C\uDCB2", "\uD83C\uDCB3", "\uD83C\uDCB4", "\uD83C\uDCB5", "\uD83C\uDCB6", "\uD83C\uDCB7", "\uD83C\uDCB8", "\uD83C\uDCB9", "\uD83C\uDCBA", "\uD83C\uDCBB", "\uD83C\uDCBD", "\uD83C\uDCBE", };
    String[] diamond = {"\uD83C\uDCC1", "\uD83C\uDCC2", "\uD83C\uDCC3", "\uD83C\uDCC4", "\uD83C\uDCC5", "\uD83C\uDCC6", "\uD83C\uDCC7", "\uD83C\uDCC8", "\uD83C\uDCC9", "\uD83C\uDCCA", "\uD83C\uDCCB", "\uD83C\uDCCD", "\uD83C\uDCCE", };
    String[] club = {"\uD83C\uDCD1", "\uD83C\uDCD2", "\uD83C\uDCD3", "\uD83C\uDCD4", "\uD83C\uDCD5", "\uD83C\uDCD6", "\uD83C\uDCD7", "\uD83C\uDCD8", "\uD83C\uDCD9", "\uD83C\uDCDA", "\uD83C\uDCDB", "\uD83C\uDCDD", "\uD83C\uDCDE", };

    ArrayList<String> deck = new ArrayList<String>();
    ArrayList<String> dealerCards = new ArrayList<String>();
    ArrayList<String> playerCards = new ArrayList<String>();

    boolean gameActive = true;

    public void initGame(){
        gameActive = true;
        initDeck();
        while(gameActive){

            resetPlayerCards();
            shuffleDeck();
            stackCard(dealerCards);
            stackCard(playerCards);
            stackCard(dealerCards);
            stackCard(playerCards);
            playerTurn();
            tools.setTimeOut(1000);
            if(gameActive){
                dealerTurn();
                if(gameActive){
                    evaluate();
                }
                else{
                    winGame();
                }
            }

            System.out.println("Do you wanna play again?\n Yes?");
            String answer = scan.next();
            if(answer.equalsIgnoreCase("yes")){
                gameActive = true;
            }
            else{
                System.out.println("Goodbye!");
                gameActive = false;
            }
        }
    }

    public void shuffleDeck(){
        Collections.shuffle(deck);
    }

    public void initDeck(){
        for(String k:spade){
            deck.add(k);
        }
        for(String k:heart){
            deck.add(k);
        }
        for(String k:diamond){
            deck.add(k);
        }
        for(String k:club){
            deck.add(k);
        }

    }

    public void stackCard(ArrayList cardSet){
        if(deck.size() == 0){
            System.out.println("There are no cards in the Deck! The Game will be reseted!");
            tools.proceedBreak();
            initGame();
        }
        String firstDeckCard = deck.get(0);
        deck.remove(0);
        cardSet.add(firstDeckCard);
    }

    public int checkValue(ArrayList<String> cardSet){
        boolean isASS = false;
        int[] value = new int[10];
        int sum = 0;
        for(int i = 0; i < cardSet.size(); i++){

            for(int j = 0; j < spade.length; j++){
                if(spade[j].equals(cardSet.get(i))){
                    value[i] = j+1;
                    if (value[i] > 10){
                        value[i] = 10;
                    }
                }
            }

            for(int j = 0; j < heart.length; j++){
                if(heart[j].equals(cardSet.get(i))){
                    value[i] = j+1;
                    if (value[i] > 10){
                        value[i] = 10;
                    }
                }
            }

            for(int j = 0; j < diamond.length; j++){
                if(diamond[j].equals(cardSet.get(i))){
                    value[i] = j+1;
                    if (value[i] > 10){
                        value[i] = 10;
                    }
                }
            }

            for(int j = 0; j < club.length; j++){
                if(club[j].equals(cardSet.get(i))){
                    value[i] = j+1;
                    if (value[i] > 10){
                        value[i] = 10;
                    }
                }
            }

            if(value[i] == 1){
                isASS = true;
                value[i] = 11;
            }
        }

        for( int k:value){
            sum = sum + k;
        }

        if(isASS && sum > 21){
            sum = 0;
            for( int k:value){
                if(k == 11){
                    k = 1;
                }
                sum = sum + k;
            }
        }

        return sum;

    }


    public void resetPlayerCards(){
        if(!playerCards.isEmpty()){
            playerCards.clear();
        }
        if(!dealerCards.isEmpty()){
            dealerCards.clear();
        }
    }

    public void playerTurn(){
        boolean active = true;
        while(active){
            tools.clearConsole();
            int sum = checkValue(playerCards);
            showDealerCard(false);
            showPlayerCard(playerCards);
            System.out.println(sum);
            if(sum > 21){
                looseGame();
                active = false;
            }
            else{
                System.out.println("Hit(0)");
                //System.out.println("double(1)");
                System.out.println("Stand(1)");
                int input = scan.nextInt();
                switch(input){
                    case 0:
                        stackCard(playerCards);
                        break;
                    /*case 1:
                        stackCard(playerCards);
                        active = false;
                        break;*/
                    case 1:
                        active = false;
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void showPlayerCard(ArrayList<String> cardSet){
        for(String k:cardSet){
            System.out.print(k + " ");
        }
        System.out.println();
    }

    public void dealerTurn(){
        boolean dealerActive = true;
        while (dealerActive){
            tools.clearConsole();
            int sum = checkValue(dealerCards);
            showDealerCard(true);
            System.out.println(checkValue(dealerCards));
            showPlayerCard(playerCards);
            if(sum < checkValue(playerCards)){
                tools.setTimeOut(1500);
                stackCard(dealerCards);
            }
            else{
                if(sum > 21){
                    gameActive = false;
                }
                dealerActive = false;
            }
        }

    }

    public void showDealerCard(boolean dealerTurn){
        System.out.println("Dealer Cards:");
        if(!dealerTurn){
            System.out.println(dealerCards.get(0) + " \uD83C\uDCA0\n");
        }
        else{
            showPlayerCard(dealerCards);
        }
    }

    public void looseGame(){
        System.out.println("You Loose!");
        gameActive = false;
    }

    public void winGame(){
        System.out.println("You Win");
    }

    public void drawGame(){
        System.out.println("It's a draw!");
    }

    public void evaluate(){
        int sumPlayer = checkValue(playerCards);
        int dealerCard = checkValue(dealerCards);
        if(sumPlayer > dealerCard){
            winGame();
        }
        if(sumPlayer == dealerCard){
            drawGame();
        }
        else{
            looseGame();
        }
    }


}
