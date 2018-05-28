package org.academiadecodigo.stormrooters.games_afoot;

public class Rabbit {

    private boolean alive;
    private boolean scared;

    public Rabbit() {
        this.alive = true;
        this.scared = false;
    }

    public void beScared() {
        this.scared = true;
    }

    public void dye() {
        this.alive = false;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isScared() {
        return scared;
    }
}
