public class player {
    private String name = "";
    private int maxhealth = 100;
    private int health = 100;
    private int damage = 0;
    private String[] actions = {"Fight", "Guard", "Counter", "Heal", "Debuff", "Use Item", "Check (doesn't consume action)"};
    private item[] items = new item[15];
    private int itemshad = 0;
    
    public player() {
        name = "";
        health = 100;
        maxhealth = 100;
        damage = 0;
    }

    public player(String nam, int heal, int maxh, int dam) {
        name = nam;
        health = heal;
        maxhealth = maxh;
        damage = dam;
    }

    public player(String nam) {
        name = nam;
        health = 100;
        maxhealth = 100;
        damage = 10;
    }

    public player(String nam, int maxh) {
        name = nam;
        health = maxh;
        maxhealth = maxh;
        damage = 10;
    }

    public player(int maxh, int dam) {
        name = "";
        health = maxh;
        maxhealth = maxh;
        damage = dam;
    }

    public void setName(String nam) {
        name = nam;
    }
    
    public void setHealth(int heal) {
        health = heal;
    }

    public void setDamage(int dam) {
        damage = dam;
    }

    public void setMaxHealth(int maxh) {
        maxhealth = maxh;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }
    public int getMaxHealth() {
        return maxhealth;
    }

    public String toString(){
        return name + " with currently " + health + " health, " + maxhealth + " max health and " + damage + " damage";
    }

    public String getAction(int c) {
        return actions[c-1];
    }

    public void showActions() {
        main.println("Your actions are: ");
        for (int i = 0; i < actions.length ; i++)
        main.println((i+1) + ": " + actions[i]);
    }

    public int hma() {
        return actions.length;
    }

    public int getItemshad() {
        return itemshad;
    }

    public void addItem(item i) {
        if (itemshad < 15) {
            items[itemshad] = i;
            main.println("You got a " + i.getName() + "!");
        } else {
            main.println("Your item storage is full. ");
        }
    }//i only handle errors here

    public void useItem(int i) {
        if (itemshad > 0) {
            main.println("You used a " + items[i].getName() + ". ");
            main.idle(1);
            this.setHealth(this.getHealth() + items[i].getBoost());
            main.println("You healed for " + items[i].getBoost() + " health. ");
        } else {
            main.println("You have no items to use. ");
        }
    }

    public void displayItems() {
        int c = 1;
        for (item i : items) {
            main.println(c + ". " + i);
        }
    }

}
