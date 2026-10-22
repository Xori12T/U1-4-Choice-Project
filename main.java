/*
Commenter: Elle

This is a really fun game. I tried the edge cases
and it prevented me from breakin the game. There was an
out-of-bound error I encountered, but William was able to resolve it. 
I didn't notice any syntax and logical errors.
I didn't run into infinite loops.

Room for Improvement?
Maybe adding more opponents the user could fight against
*/


/*
Commenter: Akaran
I didn't notice any errors or infinite loops.
Maybe add a fight with one of the bosses and have random opponents like goblins and skeletonsleading up to it.
game short but good
u should add more delay between outputs

Commenter: Darren
No erros with infinite loops. Suggestions-add more fights maybe multiple opponents at the same time
Good interesting game, good checking for valid inputs, nice waiting period that delays each action
*/

import java.util.Scanner;
//scanner

public class main {

    //added healing items as a class, players and only bosses can use them, and monsters and bosses drop them.
    private static item soda = new item("Soda",5);
    private static item curry = new item("Curry", 12);
    private static item masonhair = new item("Mason's Hair", -7);
    private static item lucashair = new item("Lucas's Hair", 20);
    //rationale: i think eating mason's hair would hurt u, but lucas's hair is actually way more nutritional and heals 20 health irl too.
    //evidence: personal experience
    private static item chugjug = new item("ChugJug", 17);
    private static item apple = new item("Apple", 1);
    private static item motherboard = new item("Motherboard ASRock B550M PRO4 AMD B550 AMD AM4", 19);
    private static item glass = new item("Glass Bottle", -2);
    private static item chag = new item("Lake Chargoggagoggmanchauggagoggchaubunagungamaugg", 10);

    private static item[] allitems = {soda, curry, chugjug, apple, motherboard, glass, lucashair, masonhair, chag};

    private static opponent goblin = new opponent("Goblin", 10, 2);
    private static opponent goblin2 = new opponent("Goblin", 10, 2);
    private static opponent goblin4 = new opponent("Goblin", 10, 2);
    private static opponent goblin3 = new opponent("Goblin", 10, 2);
    private static opponent masonhairspray = new opponent("Mason's Hairspray", 5, 50);
    private static opponent orc = new opponent("Orc", 20,52);
    private static opponent slime = new opponent("Slime", 30, 3);
    private static opponent living_skeleton = new opponent("Skeleton", 15, 6);

    private static opponent belt = new opponent("Belt of Rami", 40, 8);
    private static opponent men = new opponent("Men of Steds", 80, 15);
    private static opponent beck = new opponent("The Becker", 120, 25);



    public static int easte = 0; 
    //easter egg lol

    public static void println(Object ps) {
        System.out.println(ps);
    }
    //substitue println

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
        //wait function
    }

    public static void cpl() {
        print("\033[1F\033[K");
        System.out.flush();
        //clear previous line function
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
            //idle dialogue 
        }
    }

    public static boolean battle(player play, opponent opp, Scanner bi) {
    //main battle loop
    //uses the scanner bc creating another scanner would be inefficient
    println("");
    println(opp.getName() + " approaches! ");
    println("");
    idle(1);
    int ee = easte;
    while (play.getHealth() > 0 && opp.getHealth() > 0) {

        String oppact = opp.getAction();
        String tes = "";
        while (true) {
            println("");
            println("What do you do? Enter a number. ");
            //gets player action
            play.showActions();
            String line = bi.nextLine();

            int choice;
            try {
                choice = Integer.parseInt(line.trim());
                if (choice > 0 && choice <= play.hma()) {
                    tes = play.getAction(choice);
                    break; // valid input means leave input loop
                } else { //doesn't accept invalid input
                    println("That's not a valid choice buddy. ");
                    sleep(2000);
                    for (int i = 0; i <= play.hma() + 1; i++) cpl();
                }
            } catch (NumberFormatException ignored) { 
                println("That's not a choice buddy.");
                sleep(2000);
                for (int i = 0; i <= play.hma() + 1; i++) cpl();
            }
        }

        int pD = play.getDamage();
        int oD = opp.getDamage();
        //pre calc damage

        int pHalf = (int) Math.ceil(pD / 2.0);
        int pFifth = (int) Math.ceil(pD / 5.0);

        int oHalf = (int) Math.floor(oD / 2.0);
        int oFifth = (int) Math.floor(oD / 5.0);
        

        boolean consumedTurn = false; 
        //battle logic
        println(tes);
        if ("Fight".equals(tes)) {
            println("You decided to fight! ");
            idle(1);

            if ("Guard".equals(oppact)) {
                println(opp.getName() + " guarded. ");
                idle(1);
                opp.setHealth(Math.max(0, opp.getHealth() - pHalf));
                println("You dealt " + pHalf + " damage. ");
                println(opp.getName() + " has " + opp.getHealth() + " health left. ");
            } else if ("Counter".equals(oppact)) {
                println(opp.getName() + " countered you! ");
                idle(1);
                opp.setHealth(Math.max(0, opp.getHealth() - pFifth));
                play.setHealth(Math.max(0, play.getHealth() - oHalf));
                println("You dealt " + pFifth + " damage. ");
                println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                idle(1);
                println(opp.getName() + " dealt " + oHalf + " damage. ");
                println("You have " + play.getHealth() + " health left. ");
            } else { 
                println(opp.getName() + " decided to fight. ");
                opp.setHealth(Math.max(0, opp.getHealth() - pD));
                play.setHealth(Math.max(0, play.getHealth() - oD));
                println("You dealt " + pD + " damage. ");
                println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                idle(1);
                println(opp.getName() + " dealt " + oD + " damage. ");
                println("You have " + play.getHealth() + " health left. ");
            }
            consumedTurn = true;

        } else if ("Guard".equals(tes)) {
            println("You decided to guard. ");
            idle(1);
            if ("Guard".equals(oppact)) {
                println(opp.getName() + " guarded. ");
                println("Nothing happened lol");
            } else if ("Counter".equals(oppact)) {
                println(opp.getName() + " countered. ");
                println("But there was nothing to counter. ");
            } else { 
                println(opp.getName() + " decided to fight. ");
                play.setHealth(Math.max(0, play.getHealth() - oHalf));
                println(opp.getName() + " dealt " + oHalf + " damage. ");
                println("You have " + play.getHealth() + " health left. ");
            }
            consumedTurn = true;

        } else if ("Counter".equals(tes)) {
            println("You decided to counter the next attack. ");
            idle(1);
            if ("Guard".equals(oppact)) {
                println(opp.getName() + " guarded. ");
                println("Nothing happened lol");
            } else if ("Counter".equals(oppact)) {
                println(opp.getName() + " countered. ");
                println("Bro imagine missing both your counters lol ");
            } else { 
                println(opp.getName() + " got countered by you! ");
                opp.setHealth(Math.max(0, opp.getHealth() - pHalf));
                play.setHealth(Math.max(0, play.getHealth() - oFifth));
                println("You dealt " + pHalf + " damage. ");
                println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                idle(1);
                println(opp.getName() + " dealt " + oFifth + " damage. ");
                println("You have " + play.getHealth() + " health left. ");
            }
            consumedTurn = true;

        } else if ("Heal".equals(tes)) {
            println("You decided to heal yourself. ");
            idle(1);
            int healAmount = pD;
            play.setHealth(Math.min(play.getMaxHealth(), play.getHealth() + healAmount));
            println("You healed " + healAmount + " health. ");
            println("You have " + play.getHealth() + " health left. ");
            idle(1);

            if ("Guard".equals(oppact)) {
                println(opp.getName() + " guarded. ");
                println("Nothing happened lol");
            } else if ("Counter".equals(oppact)) {
                println(opp.getName() + " countered. ");
                println("But there was nothing to counter.");
            } else { 
                println(opp.getName() + " decided to fight. ");
                play.setHealth(Math.max(0, play.getHealth() - oD));
                idle(1);
                println(opp.getName() + " dealt " + oD + " damage. ");
                println("You have " + play.getHealth() + " health left. ");
            }
            consumedTurn = true;

        } else if ("Use Item".equals(tes)) {
            println("You decided to use an item. ");
            idle(1);
            while (true) {
            println("What item do you use? Enter a number. ");
            //gets player items
            play.displayItems();
            String line = bi.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(line.trim());
                if (choice > 0 && choice <= play.getItemshad()) {
                    play.useItem(choice);
                    break; // valid input means leave input loop
                } else { //doesn't accept invalid input
                    println("That's not a valid choice buddy. ");
                    sleep(2000);
                    for (int i = 0; i < play.getItemshad() + 1; i++) cpl();
                }
            } catch (NumberFormatException ignored) { 
                println("That's not a choice buddy.");
                sleep(2000);
                for (int i = 0; i <= play.hma() + 1; i++) cpl();
            }
        }

            if ("Guard".equals(oppact)) {
                println(opp.getName() + " guarded. ");
                println("Nothing happened lol");
            } else if ("Counter".equals(oppact)) {
                println(opp.getName() + " countered. ");
                println("But there was nothing to counter.");
            } else { 
                println(opp.getName() + " decided to fight. ");
                play.setHealth(Math.max(0, play.getHealth() - oD));
                idle(1);
                println(opp.getName() + " dealt " + oD + " damage. ");
                println("You have " + play.getHealth() + " health left. ");
            }
            consumedTurn = true;

        } else if ("Debuff".equals(tes)) {
            println("You decided to debuff the enemy. ");
            idle(1);

            if ("Guard".equals(oppact)) {
                println(opp.getName() + " guarded. ");
                println("Nothing happened lol ");
                idle(1);
                if (oD > 2) {
                    opp.setDamage(oD - 2);
                    println("You debuffed " + opp.getName() + "'s damage by 2. ");
                } else {
                    println("Yo bro he does like two damage why r u debuffing him. ");
                    idle(1);
                    println("r u scared or smth?");
                    sleep(1000);
                    consumedTurn = false; 
                }
            } else if ("Counter".equals(oppact)) {
                println(opp.getName() + " countered. ");
                println("But there was nothing to counter.");
                idle(1);
                if (oD > 2) {
                    opp.setDamage(oD - 2);
                    println("You debuffed " + opp.getName() + "'s damage by 2. ");
                } else {
                    println("Yo bro he does like two damage why r u debuffing him. ");
                    idle(1); //doesn't consume turn if fail debuff
                    println("r u scared or smth?");
                    sleep(1000);
                    consumedTurn = false; 
                }
            } else { 
                println(opp.getName() + " decided to fight. ");
                if (oD > 2) {
                    opp.setDamage(oD - 2);
                    println("You debuffed " + opp.getName() + "'s damage by 2. ");
                    int oDnew = opp.getDamage();
                    play.setHealth(Math.max(0, play.getHealth() - oDnew));
                    println(opp.getName() + " dealt " + oDnew + " damage. ");
                    println("You have " + play.getHealth() + " health left. ");
                } else {
                    println("Yo bro he does like two damage why r u debuffing him. ");
                    idle(1);
                    println("r u scared or smth?");
                    sleep(1000);
                    consumedTurn = false; 
                }
            }
        } else {
            ee++;
            println("You decided to check the enemy");
            //doesnt consume turn to check
            println("Enemy: " + opp.toString());
            if (ee > 10) {
                println("You've checked the enemy more than 10 times. ");
                cpl();
                idle(1);
                println("What are you, a nerd?");
                idle(1);
                cpl();
            }
            idle(1);
            println("When you are ready, press enter. ");
            bi.nextLine();
        }

        if (!consumedTurn) {
            for (int i = 0; i < play.hma() + 7; i++) cpl();
            continue;
            //clears if u didn't use an action
        }
        play.setHealth(Math.max(0, Math.min(play.getHealth(), play.getMaxHealth())));
        opp.setHealth(Math.max(0, opp.getHealth()));
        //makes sure health makes sense

        idle(1);
    } 

    // result
    if (play.getHealth() <= 0) {
        println("Yo bro u lost.");
        idle(1);
        println("Skill issue lol. *laughing emoji*");
        idle(2);
        println("Bye. ");
        easte = ee;
        return false;
    } else {
        println("Yo u won. ");
        idle(1);
        println("Good job bro");
        println("Have some buffs: ");
        println("Max Health increased by 10");
        play.setMaxHealth(play.getMaxHealth() + 10);
        idle(1);
        println("Full Heal");
        play.setHealth(play.getMaxHealth());
        idle(1);
        println("And plus 10 damage. ");
        play.setDamage(play.getDamage() + 10);
        idle(1);
        int tirv = (int)(Math.random()* allitems.length);
        println("Item dropped: " + allitems[tirv].getName());
        play.addItem(allitems[tirv]); //no error handling here, all in player function
        easte = ee;
        return true;
    }
    
}
    //substitute print
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String temp = "";
        
        //dialogue
        // idle(1);
        // println("Hello! My name is Verity. I'm your personal helper friend!");
        // idle(3);
        // println("Ask me anything! I know everything!");
        // idle(3);
        // println("Except for your name... ");
        // idle(2);
        // cpl();
        println("What is your name? ");
        String nam = input.nextLine();
        // idle(2);
        // println("Hello " + nam + "! That's a really nice name!");
        // idle(1);
        // println("Unfortunately, we are trapped in the local Chick-Fil-A right now, and there are 3 bosses ahead of us.");
        // idle(4);
        // println("You have the fearsome Belt of Rami,");
        // idle(2);
        // println("The battle hardened Men of Steds,");
        // idle(2);
        // println("And finally you face the indomitable Becker.");
        // idle(2);
        player mc = new player(nam, 100, 100, 5);
        // idle(1);
        // println(mc.toString() + ", are you ready to face the trials set before you? ");
        // temp = input.nextLine();
        // if (temp.toLowerCase().contains("ye") || temp.toLowerCase().contains("uh")) println("Let us begin. ");
        // else{
        //     idle(2);
        //     println("Tf u mean nuh uh");
        //     idle(1);
        //     println("Too bad so sad.");

        // } 

        idle(2);
        println("Look Out!! A Goblin!! ");
        idle(2);
        
        if (battle(mc, goblin2, input)) {
            println("Phew. You made it.");
            idle(1);

        } else {
            println("How do u lose the first fight? ");
            System.exit(0); 
        }

        println("Well, might as well fight some more goblins to level up. ");
        idle(1);
        println("Hey, there's one right there! ");

        if (battle(mc, goblin, input)) {
            println("Good job!");
            idle(1);
        } else {
            idle(2);
            println("And you were finally startng to get good...");
            System.exit(0);
        }

        println("Well, I think you can challenge the first boss now!");
        idle(1);
        println("Good luck!");

        if (battle(mc, belt, input)) {
            println("Yoo u beat the first boss!");
            idle(1);
        } else {
            println("You lost.");
            System.exit(0);
        }

        



    }
}