package com.company.gameEngine;

import com.company.gameEngine.Character;

public class Wizard extends Character {

    public Wizard(){
        super(5, 5, 0, "Wizard", "fingertips", "Gandalf");
    }


    //getter
    public int getHitPoints(){
        return hitPoints;
    }

    public int getWizardMax(){
        return maxHp;
    }

    public int getWizardMin(){
        return minHp;
    }

    public String getCharacterType() {
        return characterType;
    }

    public String getCharacterName() {
        return characterName;
    }

    public String getWeaponType(){
        return characterWeaponType;
    }

    //setters
    public void setHitPoints(int newHp){
        hitPoints = newHp;
    }

    public void setCharacterType(String newCharType){
        characterType = newCharType;
    }

    public void setCharacterName(String newCharName){
        characterName = newCharName;
    }

    public void setCharacterWeaponType(String newCharWeapon) {
        characterWeaponType = newCharWeapon;
    }


    public String toString(){
        return super.toString();
    }

}
