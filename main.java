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
            println(".");
            sleep(250);
            cpl();
            println("..");
            sleep(250);
            cpl();
            println("...");
            sleep(250);
            cpl();
            
        }
    }

    public static boolean battle(player play, opponent opp) {
        boolean battle = true;
        Scanner bi = new Scanner(System.in);
        String tes = "";
        boolean cont = false;
        println("");
        println(opp.getName() + " approaches! ");
        println("");
        while (battle) {
            while (!cont) {
                println("What do you do? Enter a number. ");
                play.showActions();
                tes = bi.nextLine();
                for (int i = 0; i < play.hma(); i++) {
                    if (tes.contains(String.valueOf(i+1))) {
                        tes = play.getAction(i);
                        cont = true;
                    }
                }
                if (cont) continue;
                println("That's not a choice buddy.");
                sleep(2);
                for (int i = 0; i <= play.hma(); i++) cpl();
                
            }


            String oppact = opp.getAction();
            if (tes.equals("Fight")) {
                println("You decided to fight! ");
                if (oppact.equals("Guard")) {
                    println(opp.getName() + " guarded. ");
                    opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/2)));
                    println("You dealt " + (play.getDamage()/2) + " damage. ");
                    println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                } else if (oppact.equals("Counter")) {
                    println(opp.getName() + " countered you! ");
                    opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/5)));
                    play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()/2))));
                    println("You dealt " + (play.getDamage()/5) + " damage. ");
                    println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                    println(opp.getName() + " dealt " + (opp.getDamage()/2) + " damage. ");
                    println("You have " + play.getHealth() + " health left. ");
                } else if (oppact.equals("Fight")) {
                    println(opp.getName() + " decided to fight. ");
                    opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage())));
                    play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()))));
                    println("You dealt " + (play.getDamage()) + " damage. ");
                    println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                    println(opp.getName() + " dealt " + (opp.getDamage()) + " damage. ");
                    println("You have " + play.getHealth() + " health left. ");
                }
            } else if (tes.equals("Guard")) {
                println("You decided to guard! ");
                if (oppact.equals("Guard")) {
                    println(opp.getName() + " guarded. ");
                    println("Nothing happened lol");
                } else if (oppact.equals("Counter")) {
                    println(opp.getName() + " countered. ");
                    println("But there was nothing to counter. ");
                } else if (oppact.equals("Fight")) {
                    println(opp.getName() + " decided to fight. ");
                    opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/2)));
                    play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()))));
                    println(opp.getName() + " dealt " + (opp.getDamage()/2) + " damage. ");
                    println("You have " + play.getHealth() + " health left. ");
                } 
            } else if (tes.equals("Counter")) {
                println("You decided to counter the next attack. ");
                if (oppact.equals("Guard")) {
                    println(opp.getName() + " guarded. ");
                    println("Nothing happened lol");
                } else if (oppact.equals("Counter")) {
                    println(opp.getName() + " countered. ");
                    println("Bro imagine missing both your counters lol ");
                } else if (oppact.equals("Fight")) {
                    println(opp.getName() + " got countered by you! ");
                    opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/2)));
                    play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()/5))));
                    println("You dealt " + (play.getDamage()/2) + " damage. ");
                    println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                    println(opp.getName() + " dealt " + (opp.getDamage()/5) + " damage. ");
                    println(opp.getName() + " has " + play.getHealth() + " health left. ");
                } else if (tes.equals("Heal")) {
                    println("You decided to fight! ");
                    if (oppact.equals("Guard")) {
                        println(opp.getName() + " guarded. ");
                        opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/2)));
                        println("You dealt " + (play.getDamage()/2) + " damage. ");
                        println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                    } else if (oppact.equals("Counter")) {
                        println(opp.getName() + " countered you! ");
                        opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/5)));
                        play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()/2))));
                        println("You dealt " + (play.getDamage()/5) + " damage. ");
                        println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                        println(opp.getName() + " dealt " + (opp.getDamage()/2) + " damage. ");
                        println("You have " + play.getHealth() + " health left. ");
                    } else if (oppact.equals("Fight")) {
                        println(opp.getName() + " decided to fight. ");
                        opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage())));
                        play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()))));
                        println("You dealt " + (play.getDamage()) + " damage. ");
                        println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                        println(opp.getName() + " dealt " + (opp.getDamage()) + " damage. ");
                        println("You have " + play.getHealth() + " health left. ");
                    }
                }
            }
            

        }
        bi.close();
        return true;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String temp = "";
        idle(1);
        println("Hello! My name is Verity. I'm your personal helper friend!");
        idle(3);
        println("Ask me anything! I know everything!");
        idle(3);
        print("Except for your name... ");
        idle(2);
        println("I know! What is your name? ");
        String nam = input.nextLine();
        idle(2);
        println("Hello " + nam + "! That's a really nice name!");
        idle(1);
        println("Unfortunately, we are trapped in the local Chick Fil A right now, and there are 3 bosses ahead of us.");
        idle(4);
        println("You have the fearsome Belt of Rami,");
        idle(2);
        println("The battle hardened Men of Steds,");
        idle(2);
        println("And finally you face the indomitable Scottish Becker.");
        idle(2);
        player mc = new player(nam, 100, 5);
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

        idle(2);
        println("Look Out!! A Goblin!! ");
        idle(2);
        opponent goblin = new opponent("Goblin", 10, 2);
        battle(mc, goblin);
        
        opponent belt = new opponent("Belt of Rami", 40, 8);


    }
}