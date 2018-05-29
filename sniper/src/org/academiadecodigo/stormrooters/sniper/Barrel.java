package org.academiadecodigo.stormrooters.sniper;

import javax.security.auth.Destroyable;

public class Barrel implements Destroyable {

    private BarrelType barrelType;
    private int currentDamage=0;
    private boolean destroyed;

    public Barrel () {
        barrelType= BarrelType.values()[(int)Math.random()*(BarrelType.values().length+1)];
    }



    public void setDestroyed() {
        destroyed = true;
        System.out.println("KAABOOOM");
    }

    public void hit(int hit) {
        this.currentDamage += hit;
        if (currentDamage >= barrelType.getMaxDamage() ) {
            setDestroyed();
        }
    }


    public String getMessage() {
        return "Barrel";
    }

}
