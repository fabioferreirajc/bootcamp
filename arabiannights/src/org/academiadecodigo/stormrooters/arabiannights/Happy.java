package org.academiadecodigo.stormrooters.arabiannights;

public class Happy extends Genie {

    public Happy() {
        super(3);

    }


    @Override

    public void grantAWish() {

        if (getNumberOfWishes() > 0) {

            super.grantAWish();

            System.out.println("Wish");
        }

    }

}


