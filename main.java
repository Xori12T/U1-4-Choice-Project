import java.util.Scanner;

public class main {

    public static void println(Object ps) {
        System.out.println(ps);
    }

    public static void print(Object ps) {
        System.out.print(ps);
    }

    public static void sleep(int ms) {
        try {
            // Pause the execution for 2000 milliseconds (2 seconds)
            Thread.sleep(ms); 
        } catch (InterruptedException e) {
            // Handle the exception if the sleep is interrupted
            System.err.println("The sleep was interrupted!");
        }
    }

    public static void cpl() {
        print("\033[1F\033[K");
        System.out.flush();
    }

    public static void idle(int seconds) {
        for (int i = 0; i < seconds; i++) {
            println("...");
            sleep(250);
            cpl();
            println("..:");
            sleep(250);
            cpl();
            println(".:.");
            sleep(250);
            cpl();
            println(":..");
            sleep(250);
            cpl();
            
        }
    }

    public static void main(String[] args) {
        println(67);
        Scanner input = new Scanner(System.in);
        idle(1);
        println("Hello! My name is Verity. I'm your personal helper friend!");
        idle(4);
        println("Ask me anything! I know everything!");
        idle(4);
        print("Except for your name... ");
        idle(1);
        println("I know! What is your name? ");
        String nam = input.nextLine();
        idle(2);
        println("Hello " + nam + "! That's a really nice name!");
        idle(1);
        println("Unfortunately, we are trapped right now, and there are 3 bosses ahead of us.");
        println("You have the fearsome Belt of Rami,");
        println("The battle hardened Men of Steds,");
        println("And finally you face indomitable the Becker.");

    }
}