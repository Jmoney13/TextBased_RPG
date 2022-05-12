package com.company.gameEngine;
import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter writer = new BufferedWriter(new FileWriter("userInfo"));
        BufferedReader reader = new BufferedReader(new FileReader("UserInfo"));


        //creates empty player obj
        Player player = new Player();
        //ask for userInfo and store in external file
        player.getPlayerInfo(writer);

        //greet player with class choices
        System.out.println("----------------------------------------------------------------------------");
        System.out.println("Welcome to Dungeony Dungeon " + player.getPlayerUserName() + "who would you like to play as?");
        System.out.println(" ");
        player.displayClassChoices();
        //global variables for userInfo
        String userClassChoice = sc.nextLine();
        System.out.println(" ");

        //checks what the chosen class is and sets it and prints the toString()
        player.setPlayerClassChoice(userClassChoice, writer);
        player.toString();

        writer.flush();

        System.out.println("okay " + userClassChoice + " you have entered A mysterious room");

        Boss bossObj = new Boss();
        bossObj.generateBossWeapon();
        bossObj.setBossName();
        bossObj.toString();

        //instantiates a battle instance
        Battle battle = new Battle(player, bossObj);

        //runs a battle sequence which loops until player or boss health reaches zero
        battle.battleSequence(player, bossObj, writer);

        int readLines = reader.read();
        while(readLines != -1){
            System.out.print((char)readLines);
            readLines = reader.read();
        }
        System.out.println(" ");
        System.out.println("Game Ended");
    }
}
