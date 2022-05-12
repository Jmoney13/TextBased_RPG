package com.company.gameEngine;
import com.company.GameForm;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;

public class Player {
    Scanner sc = new Scanner(System.in);


    Soldier soldier = new Soldier();
    Tank tank = new Tank();
    Archer archer = new Archer();
    Wizard wizard = new Wizard();

    // array storing possible class selections for user
    Character characterArr[] = {soldier, tank, archer, wizard};

    private int playerMaxHp;
    private int playerMinHp;
    private int playerHp;
    private int playerHpUpdate;

    private String characterName;
    private String classChoice;
    private String playerWeaponType;
    private String playerAction;

    private String userName;
    private String userAge;


    public Player(){
        playerMaxHp = 0;
        playerMinHp = 0;
        playerHp = 0;
        characterName = "nameHere";
        classChoice = "no class";
        playerWeaponType = "no weapon";
        userName = " ";
        userAge = " ";
        playerAction = " ";
    }

    public void displayClassChoices() {
        Scanner sc = new Scanner(System.in);
        String arr[] = {"Soldier", "Tank", "Archer", "Wizard"};

        for(int i = 0; i< arr.length; i++){
            //gui.updateGameActivty(arr[i] + " ");

            System.out.print(arr[i] + " ");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------------------");
        //System.out.println("---------------------------");
    }

    //getters
    public void getPlayerInfo(BufferedWriter bufferedWriter) throws IOException {
        BufferedWriter writer = bufferedWriter;

        System.out.println("Please enter your UserName");
        String userName = sc.nextLine();
        setUserName(userName);
        writer.write("UserName: " + userName + " ");

        System.out.println("Please enter your age");
        String userAge = sc.nextLine();
        setUserAge(userAge);
        writer.write("Age: " + userAge);
        writer.flush();
    }

    public int getPlayerHp(){
        return playerHp;
    }

    public int getPlayerMax(){
        return playerMaxHp;
    }

    public int getPlayerMin(){
        return playerMinHp;
    }

    public String getPlayerUserName(){
        return userName;
    }

    public String getPlayerClassChoice(){
        return classChoice;
    }

    public String getPlayerAction(){
        return playerAction;
    }

    public String getPlayerWeaponType(){
        return playerWeaponType;
    }

    //setters
    public void setUserName(String name){
        userName = name;
    }

    public void setUserAge(String age){
        userAge = age;
    }

    public void setPlayerAction(String action){
        playerAction = action;
    }

    public void setPlayerHp(int hp){
        playerHp = hp;
    }

    public void setSoldier(){
        classChoice = "Soldier";
        playerHp = soldier.getHitPoints();
        playerMaxHp = soldier.getSoldierMax();
        playerMinHp = soldier.getSoliderMin();
        characterName = soldier.getCharacterName();
        playerWeaponType = soldier.getWeaponType();
    }

    public void setTank(){
        classChoice = "Tank";
        playerHp = tank.getHitPoints();
        playerMaxHp = tank.getTankMax();
        playerMinHp = tank.getTankMin();
        characterName= tank.getCharacterName();
        playerWeaponType = tank.getWeaponType();
    }

    public void setArcher(){
        classChoice = "Archer";
        playerHp = archer.getHitPoints();
        playerMaxHp = archer.getArcherMax();
        playerMinHp = archer.getArcherMin();
        characterName= archer.getCharacterName();
        playerWeaponType = archer.getWeaponType();
    }

    public void setWizard(){
        classChoice = "Wizard";
        playerHp = wizard.getHitPoints();
        playerMaxHp = wizard.getWizardMax();
        playerMinHp = wizard.getWizardMin();
        characterName= wizard.getCharacterName();
        playerWeaponType = wizard.getWeaponType();
    }

    public void setPlayerClassChoice(String choice, BufferedWriter bufferedWriter) throws IOException {
        classChoice = choice;
       BufferedWriter writer = bufferedWriter;

        boolean condition = false;
        do {
            if (choice.equals("Soldier")) {
                condition = true;
                setSoldier();
                getPlayerClassChoice();
            } else if (choice.equals("Tank")) {
                condition = true;
                setTank();
            } else if (choice.equals("Archer")) {
                condition = true;
                setArcher();
            } else if ( choice.equals("Wizard")) {
                condition = true;
                setWizard();
            } else {
                condition = false;
                System.out.println("Please enter valid class name");
                choice = sc.nextLine();
            }
        } while (condition == false);
    }

    public String toString(){
        System.out.println("---------------------------------------------------- " + "\n" +
                " you are a " + classChoice + " with " + playerHp + "HP your Class is named " + characterName +
                " your starting weapon is " + playerWeaponType + "\n" +
                "----------------------------------------------------");
        return "";
    }
}
