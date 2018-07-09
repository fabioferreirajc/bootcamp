package org.academiadecodigo.stormrooters;

public class NoItems implements CashRegister {

    @Override
    public String getItemDescription() {
        return "no items";
    }

    @Override
    public int getPrice() {
        return 0;
    }
}
