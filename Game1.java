import java.io.IOException;

/**
 * Created by henry on 28.04.16.
 */
import java.util.Scanner;

public class Game1{

    MenuTools tools = new MenuTools();

    public void mainMenu(){
        Scanner scan = new Scanner(System.in);

        boolean isActive = true;

        String playAgain = "================\n" +
                "|play Again (0)|\n"+
                "================";

        String exit = "=========\n" +
                "|EXIT(1)|\n" +
                "=========";

        while(isActive){
            System.out.println("Raten Sie die gewürfelte Zahl.");
            int trys = 0;
            int input = scan.nextInt();
            int cubeNumber;
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

    private int generateRandom(){
        int number = (int)(Math.random()*6)+1;
        return number;
    }

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

    private void showCorrect(){

        System.out.println("RIGHT!");
    }

    private void showWrong(){

        System.out.println("WRONG!\n");
    }

}
