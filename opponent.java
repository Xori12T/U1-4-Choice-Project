public class opponent {

    private int health = 0;
    private String name = "";
    private int damage = 0;
    

    public opponent() {
        name = "";
        health = 20;
        damage = 1;
    }

    public opponent(String nam, int heal, int dam) {
        name = nam;
        health = heal;
        damage = dam;
    }

    public opponent(String nam, int heal) {
        name = nam;
        health = heal;
        damage = 1;
    }
    public opponent(String nam) {
        name = nam;
        health = 20;
        damage = 1;
    }

    public opponent(int heal, int dam) {
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

    // public void defeat() {
    //     this.object
    // }


}
