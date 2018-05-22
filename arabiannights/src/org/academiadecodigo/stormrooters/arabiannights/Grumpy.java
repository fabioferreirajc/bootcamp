package org.academiadecodigo.stormrooters.arabiannights;

public class Grumpy extends Genie {

    public Grumpy() {
        super(5);
    }

    private boolean notwished=true;

    @Override

    public void grantAWish() {

        if (notwished) {
            super.grantAWish();
        }

    }


}
