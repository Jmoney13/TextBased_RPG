package com.company.gameEngine;

public class Archer extends Character {
    public Archer(){
        super(5, 5, 0, "Archer", "Bow'n Arrow", "Apollo");
    }

    //getter
    public int getHitPoints(){
        return hitPoints;
    }

    public int getArcherMax(){
        return maxHp;
    }
    public int getArcherMin(){
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
