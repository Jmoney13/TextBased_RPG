package com.company.gameEngine;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class Battle{
    Scanner sc = new Scanner(System.in);

    private int playerHp;
    private int playerMaxHp;
    private int playerMinHp;
    private int playerCurrentHp;
    private String playerChoice;
    private String playerWeapon;
    private String userAction;


    private int bossHp;
    private int bossMaxHp;
    private int bossMinHp;
    private int bossDamage;
    private String bossWeapon;
    private String bossAction;


     private Boss boss;
     private Player player;

    /**
     * @param Mplayer placeHolder player object
     * @param Mboss placeHolder Boss object
     *
     * the Battle constructor collects the data from the player object
     * such as, health, class, weapon
     *
     * the Battle constructor also collects data from the boss object
     * such as, health, and weapon, and damage
     */
     /*

    the Battle constructor collects the data from the player object
    such as, health, class, weapon

    the Battle constructor also collects data from the boss object
    such as, health, and weapon, and damage
    */
    public Battle(Player Mplayer, Boss Mboss){
        player=Mplayer;
        boss = Mboss;

        playerHp = player.getPlayerHp();
        playerMaxHp = player.getPlayerMax();
        playerMinHp = player.getPlayerMin();
        playerChoice = player.getPlayerClassChoice();
        playerWeapon = player.getPlayerWeaponType();
        userAction = player.getPlayerAction();

        bossHp = boss.getBossHp();
        bossWeapon = boss.getBossWeapon();
        bossDamage = boss.getBossDamage();
    }


    public void battleSequence(Player bPlayer, Boss bBoss, BufferedWriter bufferedWriter) throws IOException {
        Player player = bPlayer;
        Boss bossObj = bBoss;
        BufferedWriter writer = bufferedWriter;
        do {
            playerMinHp = player.getPlayerMin();
            playerHp = player.getPlayerHp();
            bossHp = bossObj.getBossHp();
            bossMinHp = bossObj.getBossMin();

            //display and set player action
            playerActionChoices();

            //Boss sets an action
            possibleBossActions();

            //check moves
            calculateResults();

            //display health stats
            System.out.println("Boss Health " + bossObj.getBossHp());
            System.out.println("your Health: " + player.getPlayerHp());

            if (bossHp == bossMinHp) {
                System.out.println("You have Defeated the Boss!!! You Win");
                writer.write(" RESULT OF GAME: boss defeated ");
                writer.flush();
                break;
            } else if (playerHp == playerMinHp) {
                System.out.println("You died Game Over");
                writer.write(" RESULT OF GAME: you Died ");
                writer.flush();
                break;
            }

        } while (playerHp > playerMinHp || bossHp > bossMinHp);//end while
    }


    //player action choices depending on the users choice of class
    public void playerActionChoices(){
        /*
        while loop until correct entry
         */
        boolean condition = false;
        while(condition == false){
        Scanner sc = new Scanner(System.in);
        System.out.println("What would you like to do? ");


        if(playerChoice.equals("Archer")) {
            String choices[] = {"shootbow", "Dodge", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }
            userAction = sc.nextLine();
            //quick fire bow
            if(userAction.equals(choices[0]) || userAction.equals("ShootBow") || userAction.equals("shootBow") || userAction.equals("Shootbow") || userAction.equals("Shoot Bow")
                || userAction.equals("shoot Bow") || userAction.equals("Shoot bow")){
                condition = true;
                player.setPlayerAction(userAction);
            //dodge
            }else if(userAction.equals(choices[1]) || userAction.equals("dodge") || userAction.equals("DODGE")){
                condition = true;
                player.setPlayerAction(userAction);

            //heal
            }else if(userAction.equals(choices[2]) || userAction.equals("heal") || userAction.equals("HEAL")){
                condition = true;
                player.setPlayerAction(userAction);
            }else{
                condition = false;
                System.out.println(" ");
                System.out.println("Nope try again");
               System.out.println(" ");
            }

        }else if(playerChoice.equals("Wizard")){
            String choices[] = {"Finger Zap", "Dodge", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }

            userAction = sc.nextLine();

            //finger zap
            if(userAction.equals(choices[0]) || userAction.equals("finger zap") || userAction.equals("FingerZap") || userAction.equals("fingerZap") || userAction.equals("Fingerzap")
                    || userAction.equals("fingerzap")){
                condition = true;
                player.setPlayerAction(userAction);

//
            //dodge
            }else if(userAction.equals(choices[1]) || userAction.equals("dodge") || userAction.equals("DODGE")){
                condition = true;
                player.setPlayerAction(userAction);


            //heal
            }else if(userAction.equals(choices[2]) || userAction.equals("heal") || userAction.equals("HEAL")){
                condition = true;
                userAction = "Heal";
                player.setPlayerAction(userAction);
            }else{
                condition = false;
                System.out.println(" ");
                System.out.println("Nope try again");
                System.out.println(" ");
            }

        }else if(playerChoice.equals("Tank")){
            String choices[] = {"HeavySwing", "Block", "Heal"};
            for(int i = 0; i < choices.length; i++){
                System.out.print(choices[i] + " ");
            }
            userAction = sc.nextLine();

            //Heavy Swing
            if(userAction.equals(choices[0]) || userAction.equals("heavySwing") || userAction.equals("Heavy Swing") || userAction.equals("heavy swing")
            || userAction.equals("heavy Swing") || userAction.equals("Heavy swing")){
                condition = true;
                player.setPlayerAction(userAction);
            //block
            }else if(userAction.equals(choices[1]) || userAction.equals("block") || userAction.equals("BLOCK")){
                condition = true;
                player.setPlayerAction(userAction);

            //heal
            }else if(userAction.equals(choices[2]) || userAction.equals("heal") || userAction.equals("HEAL")){
                condition = true;
                player.setPlayerAction(userAction);

            }else{
                condition = false;
                System.out.println(" ");
                System.out.println("Nope try again");
                System.out.println(" ");
            }


        }else if(playerChoice.equals("Soldier")){
            String choices[] = {"SwingSword", "Dodge", "Heal"};
            for(int i = 0; i< choices.length; i++){
                 System.out.print(choices[i] + " ");
            }
            userAction = sc.nextLine();

            //Swing Sword
            if(userAction.equals(choices[0]) || userAction.equals("swingsword") || userAction.equals("swingSword") || userAction.equals("swing sword") || userAction.equals("Swing Sword")) {
                condition = true;
                player.setPlayerAction(userAction);

            //dodge
            }
            else if(userAction.equals(choices[1]) || userAction.equals("dodge") || userAction.equals("DODGE")){
                condition = true;
                player.setPlayerAction(userAction);

            //heal
            }else if(userAction.equals(choices[2]) || userAction.equals("heal") || userAction.equals("HEAL")){
                condition = true;
                player.setPlayerAction(userAction);
            }else{
                condition = false;
                System.out.println(" ");
                System.out.println("Nope try again");
                System.out.println(" ");
            }

        }else{
            System.out.println("outside else");
        }

        }//end while
    }//end playerActionChoices

    public void possibleBossActions(){
        if(bossWeapon.equals("Club")){
            Random rand = new Random();
            String bossActions[] = {"Swing", "Dodge", "Cry"};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];
                //swing
                if(bossAction.equals(bossActions[0])){
                    boss.setBossAction(bossAction);
                //dodge
                }else if(bossAction.equals(bossActions[1])){
                    boss.setBossAction(bossAction);
                 //Cry
                }else if(bossAction.equals(bossActions[2])){
                    boss.setBossAction(bossAction);
                }else{
                    System.out.println("boss failed to select a move in club");
                }
            System.out.println("your enemy Used " + bossAction);

        }else if(bossWeapon.equals("Bear Claw")){
            Random rand = new Random();
            String bossActions[] = {"Scratch", "Pounce", "Block"};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];
                //scratch
                if(bossAction.equals(bossActions[0])){
                    boss.setBossAction(bossAction);
                //pounce
                }else if(bossAction.equals(bossActions[1])){
                    boss.setBossAction(bossAction);
                //block
                }else if(bossAction.equals(bossActions[2])){
                    boss.setBossAction(bossAction);
                }
                    else{
                    System.out.println("boss failed to select a move in bear claws");
                }

            System.out.println("your enemy Used " + bossAction);

        }else if(bossWeapon.equals("Wand")){
            Random rand = new Random();
            String bossActions[] = {"Zap", "Block", "Zoop", "Cry"};
            int upperBound = bossActions.length;
            int randomBossAction = rand.nextInt(upperBound);
            bossAction = bossActions[randomBossAction];
                //if boss chooses zap
                if(bossAction.equals(bossActions[0])){
                    boss.setBossAction(bossAction);
                //if boss chooses Block
                }else if(bossAction.equals(bossActions[1])) {
                    boss.setBossAction(bossAction);

                //if boss chooses zoop
                }else if(bossAction.equals(bossActions[2])){
                    boss.setBossAction(bossAction);
                //cry
                }else if(bossAction.equals(bossActions[3])){
                    boss.setBossAction(bossAction);
                }else{
                    System.out.println("boss failed to select a move in wand");
                }
            System.out.println("your enemy Used " + bossAction);
        }else
            System.out.println("boss failed to select move");
    }

    public void calculateResults(){
        try {
            userAction = player.getPlayerAction();
            String classChoice = player.getPlayerClassChoice();
                //calculate soldier moves
            switch(classChoice){
                case "Soldier": if(userAction.equals("SwingSword") || userAction.equals("swingsword") || userAction.equals("swingSword") || userAction.equals("swing sword") || userAction.equals("Swing Sword")){
                    if(bossAction.equals("Dodge") || bossAction.equals("Block")){
                        System.out.println("your attack has no effect");
                    }else
                        playerLightAttack();
                }else if(userAction.equals("Dodge")){
                    System.out.println("you used 'Dodge' his move has no effect");
                }else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")) {
                    player.getPlayerHp();
                    if(playerHp != playerMaxHp) {
                        System.out.println("You have Healed");
                        playerHeal();
                    }else{
                        player.getPlayerHp();
                        System.out.println("Soldier");
                        System.out.println("Already Full health please select a different move");
                    }
                }
                break;

                case "Tank": //calculate tank moves
                    if(userAction.equals("HeavySwing") || userAction.equals("heavySwing") || userAction.equals("Heavy Swing") || userAction.equals("heavy swing")
                            || userAction.equals("heavy Swing") || userAction.equals("Heavy swing")){
                        if(bossAction.equals("Dodge") || bossAction.equals("Block")){
                            System.out.println("your attack has no effect");
                        }else{
                            playerLightAttack();
                        }
                    }else if(userAction.equals("Block") || userAction.equals("block") || userAction.equals("BLOCK")){
                        System.out.println("you blocked");
                    }else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")){
                        player.getPlayerHp();
                        if(playerHp != playerMaxHp) {
                            System.out.println("You have Healed");
                            playerHeal();
                        }else{
                            player.getPlayerHp();
                            System.out.println("Tank");
                            System.out.println("Already Full health please select a different move");
                        }
                    }
                    break;
                case "Wizard": //calculate wizard moves
                    if(userAction.equals("Finger Zap") || userAction.equals("finger zap") || userAction.equals("FingerZap") || userAction.equals("fingerZap") || userAction.equals("Fingerzap")
                            || userAction.equals("fingerzap")){
                        if (bossAction.equals("Dodge") || bossAction.equals("Block"))
                            System.out.println("your attack has no effect");
                        else
                            playerLightAttack();
                    }else if(userAction.equals("Dodge") || userAction.equals("dodge") || userAction.equals("DODGE")){
                        System.out.println("You used Dodge");
                    }else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")){
                        player.getPlayerHp();
                        if(playerHp != playerMaxHp) {
                            System.out.println("You have Healed");
                            playerHeal();
                        }else{
                            player.getPlayerHp();
                            System.out.println("Wizard");
                            System.out.println("Already Full health please select a different move");
                        }
                    }
                    break;
                case "Archer": //calculate archer moves{
                    if(userAction.equals("shootbow") || userAction.equals("ShootBow") || userAction.equals("shootBow") || userAction.equals("Shootbow") || userAction.equals("Shoot Bow")
                            || userAction.equals("shoot Bow") || userAction.equals("Shoot bow")){
                        if (bossAction.equals("Dodge") || bossAction.equals("Block"))
                            System.out.println("your attack has no effect");
                        else
                            playerLightAttack();
                    }else if(userAction.equals("Dodge") || userAction.equals("dodge") || userAction.equals("DODGE"))
                        System.out.println("You used Dodge"); //playerLosesNoHp();
                    else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")){
                        player.getPlayerHp();
                        if(playerHp != playerMaxHp) {
                            System.out.println("You have Healed");
                            playerHeal();
                        }else{
                            player.getPlayerHp();
                            System.out.println("archer");
                            System.out.println("Already Full health please select a different move");
                        }
                    }

            }//end switch


    //////////////////// CHECK BOSS MOVES ////////////////////

            bossAction = boss.getBossAction();

            //Calculate moves for club
            if(bossAction.equals("Swing")){
                if(userAction.equals("Dodge") || userAction.equals("Block")) {
                    System.out.println("His attack does no damage");
                }else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")){
                    System.out.println("You healed his attack does no damage");
                }
                else
                    bossLightAttack();
            }else if(bossAction.equals("Dodge")){
                enemyLosesNoHp();
            }else if(bossAction.equals("Cry")){
               System.out.println("He is very sad");
            }


            //calculate moves for Bear Claws
            if(bossAction.equals("Scratch")){
                if(userAction.equals("Dodge") || userAction.equals("Block")) {
                    System.out.println("His attack does no damage");
                }else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")){
                    System.out.println("You healed his attack does no damage");
                }
                else
                    bossLightAttack();
            }else if(bossAction.equals("Pounce")) {
                if(userAction.equals("Dodge") || userAction.equals("Block")) {
                    System.out.println("His attack does no damage");
                }else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")){
                    System.out.println("You healed his attack does no damage");
                }
                else
                    bossLightAttack();
            }else if(bossAction.equals("Block")){
                enemyLosesNoHp();
            }

            //Calculate Moves for wand
            if (bossAction.equals("Zap")){
                if(userAction.equals("Dodge") || userAction.equals("Block")) {
                    System.out.println("His attack does no damage");
                }else if(userAction.equals("Heal") || userAction.equals("heal") || userAction.equals("HEAL")){
                    System.out.println("You healed his attack does no damage");
                }
                else
                    bossLightAttack();
            }else if(bossAction.equals("Block")){
                enemyLosesNoHp();
            }else if(bossAction.equals("Zoop")){
                if(userAction.equals("Dodge") || userAction.equals("Block"))
                    System.out.println("His attack does no damage");
                else
                    bossLightAttack();
            }else if(bossAction.equals("Cry"))
                System.out.println("He is Very Sad");


        }catch(Exception e){
            System.out.println(e);
        }
    }



    //player effects
    public void playerHeal(){
        playerHp++;
        player.setPlayerHp(playerHp);
    }


   public void playerLightAttack(){
        bossHp--;
        boss.setBossHp(bossHp);
   }

    public void bossLightAttack(){
        playerHp--;
       player.setPlayerHp(playerHp);
    }

    public void enemyLosesNoHp(){
        int currentHealth = boss.getBossHp();
        boss.setBossHp(currentHealth);
    }
}

