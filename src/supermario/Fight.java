/*
 @author: lunde chen
 @email: lundechen@shu.edu.cn
 */

package supermario;

import java.util.ArrayList;
import java.util.Random;

class FightBase {
    public int numOfMonsters;
    public SuperMario superMario;
    public ArrayList<Monster> queueMonsters;

    public void fightAndAfterProcessing(int roundOfGame){
        int numKilled = fight();
        if(numKilled == this.numOfMonsters){
            System.out.println("\n\nSuper Mario won the fight against " + this.numOfMonsters + " monsters!");
            this.superMario.growAfterAWin();
        }
        else {
            this.superMario.numOfLives --;
            System.out.println("\n\nSuper Mario lose the fight ... and now has only " + superMario.numOfLives + " lives!");
        }
        this.fillInMonsters(roundOfGame);
    }

    public int fight(){
        return -1;
    }

    public void fillInMonsters(int roundOfGame){
        for(int i = 0; i < this.numOfMonsters; i ++){
            int randomChoice = (new Random()).nextInt(3);
            switch (randomChoice) {
                case 0:
                    queueMonsters.add(new Dragon(roundOfGame));
                    break;
                case 1:
                    queueMonsters.add(new Duck(roundOfGame));
                    break;
                case 2:
                    queueMonsters.add(new Tortoise(roundOfGame));
                    break;
            }
        }
    }
}

class Fight1vs1 extends FightBase {
    public Monster monster_1;
    public int sizeOfMonsterQueue;

    public Fight1vs1(SuperMario superMario,  ArrayList<Monster> queueMonsters, int sizeOfMonsterQueue){
        this.superMario = superMario;
        this.queueMonsters = queueMonsters;
        this.numOfMonsters = 1;
        this.sizeOfMonsterQueue = sizeOfMonsterQueue;
        this.monster_1 = queueMonsters.remove(0);
    }

    public int fight(){
        int numKilled = 0;
        if( this.superMario.strength >= this.monster_1.strength && this.superMario.agility >= this.monster_1.agility
                && this.superMario.intelligence >= this.monster_1.intelligence)
            numKilled ++;
        return numKilled;
    }
}

class Fight1vs2 extends Fight1vs1 {
    public Monster monster_2;
    public Fight1vs2(SuperMario superMario,  ArrayList<Monster> queueMonsters, int sizeOfMonsterQueue){
        super(superMario, queueMonsters, sizeOfMonsterQueue);
        this.numOfMonsters = 2;
        this.monster_2 = queueMonsters.remove(0);
    }

    public int fight(){
        int numKilled = super.fight();
        if( this.superMario.strength >= this.monster_2.strength && this.superMario.agility >= this.monster_2.agility
                && this.superMario.intelligence >= this.monster_2.intelligence)
            numKilled ++;
        return numKilled;
    }
}


class Fight1vs3 extends Fight1vs2 {
    public Monster monster_3;
    public Fight1vs3(SuperMario superMario,  ArrayList<Monster> queueMonsters, int sizeOfMonsterQueue){
        super(superMario, queueMonsters, sizeOfMonsterQueue);
        this.numOfMonsters = 3;
        this.monster_3 = queueMonsters.remove(0);
    }

    public int fight(){
        int numKilled = super.fight();
        if( this.superMario.strength >= this.monster_3.strength && this.superMario.agility >= this.monster_3.agility
                && this.superMario.intelligence >= this.monster_3.intelligence)
            numKilled ++;
        return numKilled;
    }

}

