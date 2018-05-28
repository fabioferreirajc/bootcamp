package org.academiadecodigo.stormrooters.sniper;

public class SniperRifle {

    private int probabilityGenerator;
    private int bulletDamage;
    private String name;


    public SniperRifle(String name) {
        this.bulletDamage = 40;
        this.name = name;
        System.out.println("You have " + name + "s sniper!!!");
    }


    public void shoot(Enemy enemy) {


        int sniperAccuracy = (int) (Math.random() * 9);

        if (sniperAccuracy < 1) {
            System.out.println("Target missed");
            return;
        }

        enemy.hit(bulletDamage);
    }



}
