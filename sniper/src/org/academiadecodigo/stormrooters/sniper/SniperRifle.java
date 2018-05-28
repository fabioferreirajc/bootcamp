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


    public int shot(a) {
        System.out.println("shoot!!");
        return a.getHealth()-bulletDamage;
        }

    public int getBulletDamage() {
        return bulletDamage;
    }

    //public void shootEnemy (Enemy) {
    //  probabilityGenerator = (int) (Math.random()*3);


    // }

}
