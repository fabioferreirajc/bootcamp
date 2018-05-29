package org.academiadecodigo.stormrooters.fishing;

public class Fisherman {

    private String name;
    private FishingRod fishingrod;
    private int points;


    public void gofish() {


        Fish fish = fishingrod.castLine();

        points += fish.getWeight() * fish.getSize();



    }
}
