package org.academiadecodigo.stormrooters.sniper;

import javax.security.auth.Destroyable;

public class Barrel implements Destroyable {

    BarrelType[] barrels = BarrelType.values();
    private int currentDamage=0
    private boolean destroyed;


    public void setDestroyed() {
        destroyed = true;
        System.out.println("KAABOOOM");
    }

    public void hit(int hit) {
        this.currentDamage += hit;
        if (currentDamage <= ) {
            setDestroyed();
        }
    }


    public String getMessage() {
        return "Barrel";
    }

}
