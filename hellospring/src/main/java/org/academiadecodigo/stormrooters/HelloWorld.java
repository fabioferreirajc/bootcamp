package org.academiadecodigo.stormrooters;

public class HelloWorld {

    private String myName;

    public HelloWorld() {
    }

    public HelloWorld(String oMeuNome) {
        this.myName = oMeuNome;
    }

    public void sayHello() {
        System.out.println("Hello World " + myName);
    }

    public void setMyName(String myName) {
        this.myName = myName;
    }

    public String getMyName() {
        return myName;
    }
}

