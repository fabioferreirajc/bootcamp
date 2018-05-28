package org.academiadecodigo.stormrooters.arabiannights;

public class Demon extends Genie {

    private boolean notrecycled=true;


    public Demon () {
        super(4);
    }

    @Override

    public void grantAWish () {

        if (notrecycled) {
            super.grantAWish();
            System.out.println("Wish granted!!");
        }
        else{
            System.out.println("aaaaaa");
        }
    }

    public void setNotRecycled(boolean notrecycled) {
        this.notrecycled = notrecycled;
    }


}
