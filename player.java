public class player {
    private String name = "";
    private int health = 100;
    private int damage = 0;
    
    public player() {
        name = "";
        health = 100;
        damage = 0;
    }

    public player(String nam, int heal, int dam) {
        name = nam;
        health = heal;
        damage = dam;
    }

    public player(String nam) {
        name = nam;
        health = 100;
        damage = 10;
    }

    public player(String nam, int heal) {
        name = nam;
        health = heal;
        damage = 10;
    }

    public player(int heal, int dam) {
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

    public String toString(){
        return name + " with " + health + " health and " + damage + " damage";
    }

}
