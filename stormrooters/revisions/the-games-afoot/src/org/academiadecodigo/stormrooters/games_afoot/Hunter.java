package org.academiadecodigo.stormrooters.games_afoot;

public class Hunter {

    private Hound hound;
    private Shotgun shotgun;


    public void hunt(Rabbit wabbit) {

       hound.chase(wabbit);

       shotgun.shoot(wabbit);
    }

    public void setHound(Hound hound) {
        this.hound = hound;
    }

    public void setShotgun(Shotgun shotgun) {
        this.shotgun = shotgun;
    }
}
