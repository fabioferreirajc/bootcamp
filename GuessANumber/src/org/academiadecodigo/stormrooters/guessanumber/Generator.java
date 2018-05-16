package org.academiadecodigo.stormrooters.guessanumber;

public class Generator {

    public static int generator (int limit){
        return (int) Math.ceil(Math.random() * limit);
    }


}
