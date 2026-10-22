public class boss {
    private int health = 0;
    private String name = "";
    private int damage = 0;
    private String[] bactions = {"Fight", "Guard", "Counter"};
    private item[] itlist;
    

    public boss() {
        name = "";
        health = 20;
        damage = 1;
    }

    public boss(String nam, int heal, int dam, item[] i) {
        name = nam;
        health = heal;
        damage = dam;
        itlist = i;
    }

    public boss(String nam, int heal) {
        name = nam;
        health = heal;
        damage = 1;
    }
    public boss(String nam) {
        name = nam;
        health = 20;
        damage = 1;
    }

    public boss(int heal, int dam) {
        name = "";
        health = heal;
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

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getDamage() {
        return damage;
    }

    public String getAction() {
        int choice = (int) (Math.random()*bactions.length);
        return bactions[choice];
    }

    public String toString(){
        return name + " has " + health + " health and does " + damage + " damage";
    }

    public void useItem() {
        int c = (int) (Math.random() * itlist.length);
        this.setHealth(this.getHealth() + itlist[c].getBoost());
        main.println(this.getName() + " consumed " + itlist[c].getName() + " and healed " + itlist[c].getBoost() + " health.");
        
    }

    // public void defeat() {
    //     this.object
    // }


}
