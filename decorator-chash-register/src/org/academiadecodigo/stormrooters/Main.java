package org.academiadecodigo.stormrooters;

public class Main {
    public static void main(String[] args) {
    CashRegister cashRegister= new Apple(new NoItems());

        System.out.println(cashRegister.getItemDescription()+cashRegister.getPrice());

    }




}
