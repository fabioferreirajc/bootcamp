package org.academiadecodigo.stormrooters.arabiannights;

public class Genie {

    private int numberOfWishes;



    public Genie (int numberOfWishes) {

            this.numberOfWishes=numberOfWishes;
    }





    public void grantAWish() {
        numberOfWishes-=1;
        System.out.println("1 wish granted!!");
    }



    public int getNumberOfWishes(){
        return numberOfWishes;
    }




}
