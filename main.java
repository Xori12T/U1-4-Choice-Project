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
            println("..˙");
            sleep(250);
            cpl();
            println(".˙.");
            sleep(250);
            cpl();
            println("˙..");
            sleep(250);
            cpl();
            
        }
    }

    public static void main(String[] args) {
        println(67);
        Scanner input = new Scanner(System.in);
        String temp = "";
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
        idle(1);
        println("You have the fearsome Belt of Rami,");
        idle(1);
        println("The battle hardened Men of Steds,");
        idle(1);
        println("And finally you face the indomitable Scottish Becker.");
        idle(1);
        println("What grade are you? ");
        temp = input.nextLine();
        int grad = 0;
        if (temp.contains("9")) grad = 9;
        else if (temp.contains("10")) grad = 10;
        else if (temp.contains("11")) grad = 11;
        else grad = 12;
        player mc = new player(nam, grad);
        idle(1);
        println(mc.toString() + ", are you ready to face the trials set before you? ");
        temp = input.nextLine();
        if (temp.toLowerCase().contains("ye") || temp.toLowerCase().contains("uh")) println("Let us begin. ");
        else{
            idle(2);
            println("Tf u mean nuh uh");
            idle(1);
            println("Too bad so sad.");

        } 

    }
}