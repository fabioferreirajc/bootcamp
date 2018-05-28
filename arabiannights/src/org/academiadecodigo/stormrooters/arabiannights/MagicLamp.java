package org.academiadecodigo.stormrooters.arabiannights;

public class MagicLamp {

    private int lampGenieCapacity;
    private int releasedGenie = 0;
    private int lampRecycled;
    private int rubnumber = 0;

    public MagicLamp(int lampGenieCapacity) {

        this.lampGenieCapacity = lampGenieCapacity;


    }

    public void lampRemainGenie() {

    }


    public Genie rub() {
        rubnumber++;
        if (releasedGenie >= lampGenieCapacity) {
            System.out.println("Demon apear");
            return new Demon();
        }
        System.out.println("Rubbed times  " + rubnumber);


        if (rubnumber % 2 == 0) {
            System.out.println("Happy Genie");
            releasedGenie++;
            return new Happy();
        } else {
            System.out.println("Grumpy Genie");
            releasedGenie++;
            return new Grumpy();
        }

    }

    public void recycleDemon (Genie demon) {
        //Demon demon1=(Demon)Genie;



    }

/*
    if(lampRemainGenie==0) {
        return new Demon()
    }
*/


}
