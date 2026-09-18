public class player {
    private String name = "";
    private int grade = 0;
    private int health = 100;
    private int damage = 0;
    
    public player() {
        name = "";
        grade = 0;
        health = 100;
        damage = 0;
    }

    public player(String nam, int grad, int heal, int dam) {
        name = nam;
        grade = grad;
        health = heal;
        damage = dam;
    }

    public player(String nam) {
        name = nam;
        grade = 9;
        health = 100;
        damage = 10;
    }

    public player(String nam, int grad) {
        name = nam;
        grade = grad;
        health = 100;
        damage = 10;
    }

    public player(String nam, int grad, int heal) {
        name = nam;
        grade = grad;
        health = heal;
        damage = 10;
    }

    public player(int grad, int heal, int dam) {
        name = "";
        grade = grad;
        health = heal;
        damage = dam;
    }

    public void setName(String nam) {
        name = nam;
    }

    public void setGrade(int grad) {
        grade = grad;
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

    public int getGrade() {
        return grade;
    }

    public int getDamage() {
        return damage;
    }

}
