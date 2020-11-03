/*
 @author: lunde chen
 @email: lundechen@shu.edu.cn
 */

package supermario;

import java.util.Random;

interface Growable {
   void growWithRoundOfGame(int roundOfGame);
}

class Monster {
    public String name;
    public int strength; // 力量
    public int agility; // 敏捷
    public int intelligence;  //智力
}

class SuperMario extends Monster{
    public int numOfLives;

    public SuperMario(){
        this.name = "SuperMario";
        this.numOfLives = 3;
        this.agility = 10;
        this.intelligence = 10;
        this.strength = 10;
    }

    public boolean isAlive(){
        return numOfLives >= 1;
    }

    public void growAfterAWin(){
        this.strength += (new Random()).nextInt(4) / 3;
        this.agility +=  (new Random()).nextInt(4) / 3;
        this.intelligence +=  (new Random()).nextInt(4) / 3;
    }
}


class Duck extends Monster implements Growable{
    public Duck(int roundOfGame){
        this.name = "Duck";
        this.strength = 8 ;
        this.agility = 8;
        this.intelligence = 1;
        this.growWithRoundOfGame(roundOfGame);
    }

    public void growWithRoundOfGame(int roundOfGame){
        this.strength +=  roundOfGame / 4 + (new Random()).nextInt(3) / 2;
        this.agility += roundOfGame / 4 + (new Random()).nextInt(3) / 2;
        this.intelligence += roundOfGame / 8 + (new Random()).nextInt(3) / 2;
    }

}

class Dragon extends Monster  implements  Growable{
    public Dragon(int roundOfGame){
        this.name = "Dragon";
        this.strength = 9 ;
        this.agility = 9;
        this.intelligence = 9;
        this.growWithRoundOfGame(roundOfGame);
    }

    public void growWithRoundOfGame(int roundOfGame){
        this.strength +=  roundOfGame / 2 + (new Random()).nextInt(2);
        this.agility += roundOfGame / 2 + (new Random()).nextInt(2);
        this.intelligence += roundOfGame / 2 + (new Random()).nextInt(2);
    }
}

class Tortoise extends Monster  implements  Growable{
    public Tortoise(int roundOfGame){
        this.name = "Tortoise";
        this.strength = 7 ;
        this.agility = 1;
        this.intelligence = 7;
        this.growWithRoundOfGame(roundOfGame);
    }

    public void growWithRoundOfGame(int roundOfGame){
        this.strength +=  roundOfGame / 3 + (new Random()).nextInt(2);
        this.agility += roundOfGame / 10 + (new Random()).nextInt(2);
        this.intelligence += roundOfGame / 2 + (new Random()).nextInt(2);
    }
}
