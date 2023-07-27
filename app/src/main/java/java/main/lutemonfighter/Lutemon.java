package java.main.lutemonfighter;

import java.io.Serializable;

public class Lutemon implements Serializable {

    protected String name;
    protected String lutemonType;
    protected int image;
    protected int attack;
    protected int defend;
    protected int experience;
    protected int health;
    protected int maxHealth;
    protected boolean isChecked;
    protected boolean isTrained;

    public Lutemon(String name, String lutemonType, int attack, int defend, int experience, int health, int maxHealth) {
        this.name = name;
        this.lutemonType = lutemonType;
        this.attack = attack;
        this.defend = defend;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.isChecked = false;
        this.isTrained = false;
    }

    // getter and setter methods for isChecked
    public boolean isChecked() {
        return isChecked;
    }

    public void setChecked(boolean checked) {
        isChecked = checked;
    }

    // getter and setter methods for isTrained
    public boolean isTrained() {
        return isTrained;
    }

    public void setTrained(boolean trained) {
        isTrained = trained;
    }

    public String getName() {
        return name;
    }

    public String getLutemonType() {
        return lutemonType;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefend() {
        return defend;
    }

    public int getExperience() {
        return experience;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setDefend(int defend) {
        this.defend = defend;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }
}
