package com.company.gameEngine;

import java.util.Random;

public class Boss {

    private int bossHp;
    private int bossMax;
    private int bossMin = 0;
    private String bossName;
    private String bossWeapon;
    private String bossAction;
    private int roomNumber;
    private int bossDamage;

    //this creates an empty Boss obj
    public Boss(int bossHp, String bossName, String bossWeapon, int roomNumber, int bossDamage){
       this.bossHp = bossHp;
       this.bossName = bossName;
       this.bossWeapon = bossWeapon;
       this.roomNumber = roomNumber;
       this.bossDamage = bossDamage;
    }

    public Boss(){
        this.bossMax = 8;
        this.bossMin = 0;
        this.bossHp = 8;
        this.bossName = " ";
        this.bossWeapon = " ";
        this.roomNumber = 1;
        this.bossDamage = 1;
    }

    //getters
    public int getBossHp(){
        return bossHp;
    }

    public String getBossName(){
        return bossName;
    }

    public int getBossMax(){
        return bossMax;
    }

    public int getBossMin(){
        return bossMin;
    }

    public String getBossWeapon(){
        return bossWeapon;
    }

    public int getBossDamage(){
        return bossDamage;
    }

    public int getStartingRoom(){
        return roomNumber;
    }

    public String getBossAction(){
        return bossAction;
    }

    //setters
    public void setBossName(){
        Random rand = new Random();
        String nameArray[] = {"1","2","3","4","5"};
        int name = nameArray.length-1;
        bossName = nameArray[name];
    }

    public void setBossAction(String action){
        bossAction = action;
    }

    public void setBossHp(int newHp) {
        bossHp = newHp;
    }

    public void setBossMax(int num){
        bossMax = num;
    }

    public void setBossMin(){
        bossMin = 0;
    }

    public void setBossWeapon(String weapon){
        bossWeapon = weapon;
    }

    public void setStartingRoom(int startingRoom){
        roomNumber = startingRoom;
    }


    public void generateBossWeapon(){
        //array storing all the possible weapons the bosses can randomly use
        String WeaponArr[] = {"Club", "Bear Claw", "Wand"};

        Random rand = new Random();
        //set upperbound to length of the String array containing weapons
        int upperBound = WeaponArr.length;
        //generate random value
        int randoNum = rand.nextInt(upperBound);
        //select a random index from weaponArr using randomNum
        String bossWeapon = WeaponArr[randoNum];
        this.bossWeapon = bossWeapon;
        setBossWeapon(bossWeapon);
    }

    public String toString(){
        System.out.println("Its a Horrible Creature " + "it looks like he's got " + bossHp + " HP He is holding a " + bossWeapon);
        return "";

    }
}
