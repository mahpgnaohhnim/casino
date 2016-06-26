import java.io.IOException;

/**
 * Created by henry on 02.06.16.
 */
public class MenuTools{

    public String os = System.getProperty("os.name");

    public void clearConsole(){
        if(os.equalsIgnoreCase("linux")){
            System.out.print("\033[H\033[2J");
        }
        else{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    public void proceedBreak(){
        try{
            System.out.println("To proceed, please confirm with Enter");
            System.in.read();
            clearConsole();
        }catch(IOException e){
            System.out.println("Error reading from user");
        }
    }

    public void setTimeOut(int time){
        try {
            Thread.sleep(time);
        }
        catch(InterruptedException ex) {

        }
    }

}
