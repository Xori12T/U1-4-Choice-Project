import java.util.Scanner;

public class main {

    public static int easte = 0; 

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

    public static boolean battle(player play, opponent opp, Scanner bi) {
        boolean battle = true;
        String tes = "";
        boolean cont = false;
        println("");
        println(opp.getName() + " approaches! ");
        println("");
        while (battle) {
            cont = false;
            while (!cont) {
                println("What do you do? Enter a number. ");
                play.showActions();
                tes = bi.nextLine();
                try {
                    if (Integer.valueOf(tes) <= play.hma() && Integer.valueOf(tes) > 0) {
                        tes = play.getAction(Integer.valueOf(tes));
                        cont = true;
                    }
                }  catch (NumberFormatException e) {
                    println("That's not a choice buddy.");
                    sleep(2000);
                }   
                
                if (cont) continue;
                println("That's not a choice buddy.");
                sleep(2000);
                for (int i = 0; i <= play.hma(); i++) cpl();
                
            }

            String oppact = opp.getAction();
            boolean choose = false;
            int ee = easte;
            while (!choose) {
                if (tes.equals("Fight")) {
                    println("You decided to fight! ");
                    choose = true;
                    idle(1);
                    if (oppact.equals("Guard")) {
                        println(opp.getName() + " guarded. ");
                        idle(1);
                        opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/2)));
                        println("You dealt " + (play.getDamage()/2) + " damage. ");
                        println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                    } else if (oppact.equals("Counter")) {
                        println(opp.getName() + " countered you! ");
                        idle(1);
                        opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage()/5)));
                        play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()/2))));
                        println("You dealt " + (play.getDamage()/5) + " damage. ");
                        println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                        idle(1);
                        println(opp.getName() + " dealt " + (opp.getDamage()/2) + " damage. ");
                        println("You have " + play.getHealth() + " health left. ");
                    } else if (oppact.equals("Fight")) {
                        println(opp.getName() + " decided to fight. ");
                        opp.setHealth((int) Math.ceil((opp.getHealth()-play.getDamage())));
                        play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()))));
                        println("You dealt " + (play.getDamage()) + " damage. ");
                        println(opp.getName() + " has " + opp.getHealth() + " health left. ");
                        idle(1);
                        println(opp.getName() + " dealt " + (opp.getDamage()) + " damage. ");
                        println("You have " + play.getHealth() + " health left. ");
                    }
                } else if (tes.equals("Guard")) {
                    println("You decided to guard. ");
                    choose = true;
                    idle(1);
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
                    choose = true;
                    idle(1);
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
                        idle(1);
                        println(opp.getName() + " dealt " + (opp.getDamage()/5) + " damage. ");
                        println(opp.getName() + " has " + play.getHealth() + " health left. ");
                    }
                } else if (tes.equals("Heal")) {
                    println("You decided to heal yourself. ");
                    choose = true;
                    idle(1);
                    if (oppact.equals("Guard")) {
                        println(opp.getName() + " guarded. ");
                        println("but nothing happened. ");
                        idle(1);
                        play.setHealth(play.getHealth() + play.getDamage());
                        println("You healed " + (play.getDamage()) + " health. ");
                        println("You have " + play.getHealth() + " health left. ");
                    } else if (oppact.equals("Counter")) {
                        println(opp.getName() + " countered. ");
                        println("Bro missed his counter lol.");
                        idle(1);
                        play.setHealth(play.getHealth() + play.getDamage());
                        println("You healed " + (play.getDamage()) + " health. ");
                        println("You have " + play.getHealth() + " health left. ");
                    } else if (oppact.equals("Fight")) {
                        println(opp.getName() + " decided to fight. ");
                        play.setHealth(play.getHealth() + play.getDamage());
                        println("You healed " + (play.getDamage()) + " health. ");
                        println("You have " + play.getHealth() + " health left. ");
                        idle(1);
                        play.setHealth((int) Math.floor((play.getHealth()-(opp.getDamage()))));
                        println(opp.getName() + " dealt " + (opp.getDamage()) + " damage. ");
                        println("You have " + play.getHealth() + " health left. ");
                    }
                } else if (tes.equals("Debuff")) {
                    println("You decided to debuff the enemy. ");
                    idle(1);
                    choose = true;
                    if (oppact.equals("Guard")) {
                        println(opp.getName() + " guarded. ");
                        println("but nothing happened. ");
                        idle(1);
                        if (opp.getDamage() > 2) {
                            opp.setDamage(opp.getDamage() - 2);
                            println("You debuffed " + opp.getName() + "'s damage by 2. ");
                        }
                        else {
                            println("Yo bro he does like two damage why r u debuffing him. ");
                            idle(1);
                            println("r u scared or smth?");
                            sleep(1000);
                            choose = false;
                        }
                        
                    } else if (oppact.equals("Counter")) {
                        println(opp.getName() + " countered. ");
                        println("Bro missed his counter lol.");
                        idle(1);
                        if (opp.getDamage() > 2) {
                            opp.setDamage(opp.getDamage() - 2);
                            println("You debuffed " + opp.getName() + "'s damage by 2. ");
                        }
                        else {
                            println("Yo bro he does like two damage why r u debuffing him. ");
                            idle(1);
                            println("r u scared or smth?");
                            sleep(1000);
                            choose = false;
                        }
                    } else if (oppact.equals("Fight")) {
                        println(opp.getName() + " decided to fight. ");
                        idle(1);
                        if (opp.getDamage() > 2) {
                            opp.setDamage(opp.getDamage() - 2);
                            println("You debuffed " + opp.getName() + "'s damage by 2. ");
                        }
                        else {
                            println("Yo bro he does like two damage why r u debuffing him. ");
                            idle(1);
                            println("r u scared or smth?");
                            sleep(1000);
                            choose = false;
                        }
                        println(opp.getName() + " dealt " + (opp.getDamage()) + " damage. ");
                        println("You have " + play.getHealth() + " health left. ");
                    }
                } else {
                    ee++;
                    println("You decided to check the enemy");
                    println("Enemy: " + opp.toString());
                    if (ee > 10) { 
                        println("You've checked the enemy more than 10 times. ");
                        cpl();
                        idle(1);
                        println("What are you, a nerd?");
                        idle(1);
                        cpl();

                    }
                }
                
            }
            
            if (play.getHealth() <= 0) {
                println("Yo bro u lost.");
                idle(1);
                println("Skill issue lol. *laughing emoji*");
                idle(2);
                println("Bye. ");
                return false;
            } else if (opp.getHealth() <= 0) {
                println("Yo u won. ");
                idle(1);
                println("Good job bro"); 
                println("Have some buffs: ");
                println("Max Health increased by 10");
                play.setMaxHealth(play.getMaxHealth() + 10);
                idle(1);
                println("Full Heal");
                play.setMaxHealth(play.getMaxHealth());
                idle(1);
                println("And plus 10 damage. ");
                play.setDamage(play.getDamage() + 10);
                idle(1);
                println("Battle ends");
                return true;
            }
        }
        //fallback bc it said error when i didn't have this
        return false;
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
        player mc = new player(nam, 100, 100, 5);
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
        battle(mc, goblin, input);
        
        opponent belt = new opponent("Belt of Rami", 40, 8);
        opponent men = new opponent("Men of Steds", 80, 15);
        opponent beck = new opponent("The Becker", 120, 25);


    }
}