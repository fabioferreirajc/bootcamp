package org.academiadecodigo.stormroopers.guessanumber;

public class Generator {

    public static int generator (int limit){
        return (int) Math.ceil(Math.random() * limit);
    }


}
