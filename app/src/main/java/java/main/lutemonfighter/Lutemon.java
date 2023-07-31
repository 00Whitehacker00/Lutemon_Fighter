package java.main.lutemonfighter;

import java.io.Serializable;

public class Lutemon implements Serializable {
    public String name;
    public String lutemonType;
    public int image;
    public int attack;
    public int defend;
    public int experience;
    public int health;
    public int maxHealth;
    public boolean isSelected;
    public boolean isInTraining;
    public String id;

    public Lutemon(String name, String lutemonType, int attack, int defend, int experience, int health, int maxHealth) {
        this.name = name;
        this.lutemonType = lutemonType;
        this.attack = attack;
        this.defend = defend;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.isSelected = false;
        this.isInTraining = false;
    }

    public Lutemon(String name, String lutemonType, int attack, int defend, int experience, int health, int maxHealth, int image) {
        this.name = name;
        this.lutemonType = lutemonType;
        this.attack = attack;
        this.defend = defend;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.image = image;
        this.isSelected = false;
        this.isInTraining = false;

        id = String.valueOf((int)(Math.random()));
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    public boolean isInTraining() {
        return isInTraining;
    }

    public void setIsInTraining(boolean isInTraining) {
        this.isInTraining = isInTraining;
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
    public void setName(String name) {
        this.name = name;
    }


    public void takeDamage(int damage) {
        health -= damage;
        if (health < 0) {
            health = 0;
        }
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    // Method to calculate if the lutemon defends against an attack
    public boolean defense(int enemyAttack) {
        // Calculate the effective defense value after considering the enemy's attack
        int effectiveDefense = defend - enemyAttack;

        // Determine if the lutemon manages to avoid death
        return effectiveDefense >= 0;
    }
}
