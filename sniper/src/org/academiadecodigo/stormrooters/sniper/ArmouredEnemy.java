package org.academiadecodigo.stormrooters.sniper;

import javax.security.auth.Destroyable;

public class ArmouredEnemy extends Enemy  {

    private int armour;


    public ArmouredEnemy() {
        super();
        this.armour = 50;
    }

    public String getMessage() {
        return "Armoured soldier!!";
    }

    @Override
    public void hit(int hit) {
        //armour first then health
        this.armour -= hit;

        if (this.armour <= 0)
            super.hit(hit);

        }

}
