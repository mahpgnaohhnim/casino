import java.io.IOException;

/**
 * Created by henry on 02.06.16.
 */
public class MenuTools{

    //Variable fuer den Name des Betriebssystem.
    public String os = System.getProperty("os.name");

    //Die Konsole leeren. Unterscheidet zwischen Linux und nicht Linux Betriebsystem, da Windows CMD kein Ascii Escape hat
    public void clearConsole(){
        if(os.equalsIgnoreCase("linux")){
            System.out.print("\033[H\033[2J");
        }
        else{
            System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        }
    }

    //Das Ausfuehren des Codes wird abgebrochen bis man mit Enter bestätigt hat
    public void proceedBreak(){
        try{
            System.out.println("To proceed, please confirm with Enter");
            System.in.read();
            clearConsole();
        }catch(IOException e){
            System.out.println("Error reading from user");
        }
    }

    //setTimeOut Funktion mit einheit 1000 = 1 Sekunde, da Java kein setTimeOut Funktion besitzt und das sehr nuetzlich ist.
    public void setTimeOut(int time){
        try {
            Thread.sleep(time);
        }
        //Exception abfangen
        catch(InterruptedException ex) {

        }
    }

}
