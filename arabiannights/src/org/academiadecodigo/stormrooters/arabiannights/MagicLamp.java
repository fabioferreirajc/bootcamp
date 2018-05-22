package org.academiadecodigo.stormrooters.arabiannights;

public class MagicLamp {

    private int lampGenieCapacity;
    private int lampRemainGenie;
    private int lampRecycled;
    private int rubnumber = 0;

    public MagicLamp(int lampGenieCapacity) {

        this.lampGenieCapacity = lampGenieCapacity;


    }

    public void lampRemainGenie () {

    }


    public Genie rub() {
        rubnumber++;
        System.out.println("Rubbed times  " + rubnumber);

        if (rubnumber % 2 == 0) {
            System.out.println("Happy Genie");

            return new Happy();
        } else {
            System.out.println("Grumpy Genie");
            return new Grumpy();
        }



    }
/*
    if(lampRemainGenie==0) {
        return new Demon()
    }
*/



}
