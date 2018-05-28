package org.academiadecodigo.stormrooters.sniper;

import javax.security.auth.Destroyable;

public abstract class Enemy extends GameObject implements Destroyable {

    private int health;

    private boolean isDead;


    public Enemy() {
        this.health = 100;
        this.isDead = false;
    }


    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
        System.out.println("Dead Target");
    }

    public void hit(int hit) {
        this.health -= hit;
        if (health <= 0) {
            setDead();
        }
    }

    public int getHealth() {
        return health;
    }
}
