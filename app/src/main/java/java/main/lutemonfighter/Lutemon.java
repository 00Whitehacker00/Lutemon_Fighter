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
    public boolean isInTraining; // Add the isInTraining property

    public Lutemon(String name, String lutemonType, int attack, int defend, int experience, int health, int maxHealth) {
        this.name = name;
        this.lutemonType = lutemonType;
        this.attack = attack;
        this.defend = defend;
        this.experience = experience;
        this.health = health;
        this.maxHealth = maxHealth;
        this.isSelected = false;
        this.isInTraining = false; // Initialize isInTraining to false
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
        this.isInTraining = false; // Initialize isInTraining to false
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

    // Add the getter and setter methods for isInTraining
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
}


