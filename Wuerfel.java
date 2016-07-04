import java.io.IOException;

/**
 * Created by henry on 28.04.16.
 */
import java.util.Scanner;

public class Wuerfel{

    MenuTools tools = new MenuTools();

    //Hauptmenue des Wuerfelratespiel
    public void mainMenu(){
        Scanner scan = new Scanner(System.in);

        boolean isActive = true;

        String playAgain = "================\n" +
                "|play Again (0)|\n"+
                "================";

        String exit = "=========\n" +
                "|EXIT(1)|\n" +
                "=========";

        //Solange isActive true ist wird das Spiel in der Schleife läuft. Fuehrt zu schnelle Fortsetzung des Wuerfelspiel
        while(isActive){
            System.out.println("Raten Sie die gewuerfelte Zahl.");
            int trys = 0;
            int input = scan.nextInt();
            int cubeNumber;
            //Man Ratet eine Zahl und es wird maximal bis 3mal gewuerfelt, bis die geratene Zahl gewuerfelt ist.
            do{
                trys++;

                cubeNumber = generateRandom();
                showCubeNumber(cubeNumber);
                if(input == cubeNumber){
                    showCorrect();
                    trys = 3;
                }else{
                    showWrong();
                    if(trys < 3){
                        tools.setTimeOut(500);
                        System.out.print("Roll the dice in 3...");
                        tools.setTimeOut(400);
                        System.out.print("2...");
                        tools.setTimeOut(400);
                        System.out.print("1...\n");
                        tools.setTimeOut(400);
                    }
                }
            }while(trys < 3);
            //Ausgabe nach dem Spiel
            System.out.println("");
            System.out.println("Wollen Sie weiter spielen?");
            System.out.println(playAgain);
            System.out.println(exit);

            int ask = scan.nextInt();

            switch(ask){
                case 1:
                    isActive = false;
                    break;
                default:
                    tools.clearConsole();
                    break;
            }

        }

    }

    //generiert eine Zufallszahl zwischen 1 und 6 und gibt sie zurueck
    private int generateRandom(){
        int number = (int)(Math.random()*6)+1;
        return number;
    }

    //Anzeige der Augenzahlen
    private void showCubeNumber(int num){
        String cubeNumber1 = "=====\n" +
                "| 1 |\n" +
                "=====";

        String cubeNumber2 = "=====\n" +
                "| 2 |\n" +
                "=====";

        String cubeNumber3 = "=====\n" +
                "| 3 |\n" +
                "=====";

        String cubeNumber4 = "=====\n" +
                "| 4 |\n" +
                "=====";

        String cubeNumber5 = "=====\n" +
                "| 5 |\n" +
                "=====";

        String cubeNumber6 = "=====\n" +
                "| 6 |\n" +
                "=====";



        switch (num){
            case 1:
                System.out.println(cubeNumber1);
                break;
            case 2:
                System.out.println(cubeNumber2);
                break;
            case 3:
                System.out.println(cubeNumber3);
                break;
            case 4:
                System.out.println(cubeNumber4);
                break;
            case 5:
                System.out.println(cubeNumber5);
                break;
            case 6:
                System.out.println(cubeNumber6);
                break;
        }
    }

    //Anzeige fuer richtige geratet
    private void showCorrect(){

        System.out.println("RIGHT!");
    }

    //Anzeige fuer nicht richtig geratet
    private void showWrong(){

        System.out.println("WRONG!\n");
    }

}
