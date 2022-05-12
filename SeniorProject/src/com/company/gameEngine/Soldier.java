package com.company.gameEngine;

import com.company.gameEngine.Character;

public class Soldier extends Character {


    public Soldier(){
        super(5, 5, 0, "Soldier", "Sword", "Mike");
    }


    //getter
    public int getHitPoints(){
        return hitPoints;
    }

    public int getSoldierMax(){
        return maxHp;
    }

    public int getSoliderMin(){
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
        return "you are a Soldier with " + hitPoints + " HP your Class is named " + characterName +
                " your starting weapon is " + characterWeaponType;
    }
}
