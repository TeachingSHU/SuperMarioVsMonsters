/*
 @author: lunde chen
 @email: lundechen@shu.edu.cn
 */

package com.company.supermario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int roundOfGame = 1;
        int sizeOfMonsterQueue = 3;
        SuperMario superMario = new SuperMario();
        ArrayList<Monster> monsters = new ArrayList<>();
        monsters.add(new Tortoise(roundOfGame));
        monsters.add(new Duck(roundOfGame));
        monsters.add(new Dragon(roundOfGame));

        while (superMario.isAlive()) {
            System.out.println("----------------  Round " + roundOfGame + " -----------------");
            System.out.println("We have those " + sizeOfMonsterQueue + " monsters and Super Mario: ");
            for(int i = sizeOfMonsterQueue - 1; i >= 0; i --){
                System.out.println("Monster " + (i + 1) + "  : [S = "
                        + monsters.get(i).strength + ", A = "
                        + monsters.get(i).agility + ", I = "
                        + monsters.get(i).intelligence + ", "
                        + monsters.get(i).name + "]" );
            }
            System.out.println("SuperMario " +  ": [S = "
                    + superMario.strength + ", A = "
                    + superMario.agility + ", I = "
                    + superMario.intelligence + ", "
                    + superMario.name + ", lives = "
                    + superMario.numOfLives + "]" );
            System.out.println("How many monsters Super Mario should pick to fight against?\n");

            int in = 0;
            try {
                in = scanner.nextInt();
            }
            catch (Exception e) {
                System.out.println("Error: should input an integer: 1, 2, or 3");
            }
            if(in == 1){
                Fight1vs1 fight1vs1 = new Fight1vs1(superMario, monsters, sizeOfMonsterQueue);
                fight1vs1.fightAndAfterProcessing(roundOfGame);
                roundOfGame ++;
            }
            else if(in == 2){
                Fight1vs2 fight1vs2 = new Fight1vs2(superMario, monsters, sizeOfMonsterQueue);
                fight1vs2.fightAndAfterProcessing(roundOfGame);
                roundOfGame ++;
            }
            else if(in == 3){
                Fight1vs3 fight1vs3 = new Fight1vs3(superMario, monsters, sizeOfMonsterQueue);
                fight1vs3.fightAndAfterProcessing(roundOfGame);
                roundOfGame ++;
            }
            else System.out.println("Error: should input an integer: 1, 2, or 3");
        }

        System.out.println("\n\nSuper Mario is now dead. You have to improve your playing strategy!");
        System.out.println("--------------- INSERT COIN TO PLAY AGAIN -------------------------\n\n");
    }
}
