import java.io.IOException;
import java.util.Scanner;

/**
 * Created by henry on 28.04.16.
 */
public class Main{
    public static int gameChoice = 0;


    public static void main(String[] args){
        MenuTools tools = new MenuTools();

        Game1 WuerfelSpiel = new Game1();
        Blackjack Blackjack = new Blackjack();

        Scanner scan = new Scanner(System.in);
        tools.clearConsole();
        initGame();
        while(true){
            showMenu();

            switch(gameChoice){
                case 0:
                    break;
                case 1:
                    tools.clearConsole();
                    WuerfelSpiel.mainMenu();
                    tools.clearConsole();
                    break;
                case 2:
                    tools.clearConsole();
                    Blackjack.initGame();
                    tools.clearConsole();
                default:
                    break;
            }
        }
    }

    private static void initGame(){
        MenuTools tools = new MenuTools();

        tools.clearConsole();
        System.out.println(" ██████╗ █████╗ ▄▄███▄▄·██╗███╗   ██╗ ██████╗     \n" +
                "██╔════╝██╔══██╗██╔════╝██║████╗  ██║██╔═══██╗    \n" +
                "██║     ███████║███████╗██║██╔██╗ ██║██║   ██║    \n" +
                "██║     ██╔══██║╚════██║██║██║╚██╗██║██║   ██║    \n" +
                "╚██████╗██║  ██║███████║██║██║ ╚████║╚██████╔╝    \n" +
                " ╚═════╝╚═╝  ╚═╝╚═▀▀▀══╝╚═╝╚═╝  ╚═══╝ ╚═════╝     \n" +
                "                                                  \n" +
                "██████╗ ███████╗██╗     ██╗   ██╗██╗  ██╗███████╗ \n" +
                "██╔══██╗██╔════╝██║     ██║   ██║╚██╗██╔╝██╔════╝ \n" +
                "██║  ██║█████╗  ██║     ██║   ██║ ╚███╔╝ █████╗   \n" +
                "██║  ██║██╔══╝  ██║     ██║   ██║ ██╔██╗ ██╔══╝   \n" +
                "██████╔╝███████╗███████╗╚██████╔╝██╔╝ ██╗███████╗ \n" +
                "╚═════╝ ╚══════╝╚══════╝ ╚═════╝ ╚═╝  ╚═╝╚══════╝");
        System.out.println("START GAME");
        tools.proceedBreak();
    }

    private static void showMenu(){
        MenuTools tools = new MenuTools();
        boolean menu = true;
        Scanner scan = new Scanner(System.in);
        while(menu){
            tools.clearConsole();
            String game1 = "===========\n" +
                    "|Würfel(1)|\n" +
                    "===========";
            String game2 =  "==============\n" +
                    "|Blackjack(2)|\n" +
                    "==============";
            String exit = "=========\n" +
                    "|EXIT(3)|\n" +
                    "=========";

            System.out.println(game1);
            System.out.println(game2);
            System.out.println(exit);

            int input = scan.nextInt();
            switch(input){
                case 1:
                    gameChoice = 1;
                    menu = false;
                    break;
                case 2:
                    gameChoice = 2;
                    menu = false;
                    break;
                case 3:
                    gameOver();
                    break;
                default:
                    break;
            }
        }

    }

    private static void gameOver(){
        MenuTools tools = new MenuTools();
        tools.clearConsole();
        System.out.println("Game Over");
        System.exit(0);
    }


}
