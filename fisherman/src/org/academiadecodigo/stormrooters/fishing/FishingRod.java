package org.academiadecodigo.stormrooters.fishing;

public class FishingRod {

    private String name;
    private String color;

    public FishingRod(String name, String color) {


        this.name = name;
        this.color = color;

    }


    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public Fish castLine() {

        int size = (int) (Math.random() * 49 + 51);
        int weight = (int) (Math.random() * 3 + 2);
        Fish fish = new Fish(size, weight);

        return fish;


    }


}
