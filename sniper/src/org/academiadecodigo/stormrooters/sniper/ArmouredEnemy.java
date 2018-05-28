package org.academiadecodigo.stormrooters.sniper;

public class ArmouredEnemy extends Enemy {

    private int armour;


    public ArmouredEnemy () {
       super();
       this.armour=50;
    }

    public int getArmour () {
        return armour;
    }

   // public void hit (int){

    //}
}
