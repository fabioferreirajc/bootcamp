package org.academiadecodigo.stormrooters.sniper;

public abstract class  Enemy extends GameObject {

    private int health;

    private boolean isDead;


    public Enemy () {
        this.health=100;
        this.isDead=false;
    }



    public int getHealth () {
        return health;
    }


    public boolean isDead() {
        return isDead;
    }

    public void setDead() {
        isDead = true;
    }

    public void hit (int hit){
        this.health-=hit;
        if(health<=0) {
            isDead();
        }
    }
}
