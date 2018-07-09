package org.academiadecodigo.stormrooters;

public class ItemList implements CashRegister{

    public CashRegister itemList;


    public ItemList(CashRegister item) {
        this.itemList=item;
    }

    @Override
    public String getItemDescription() {
        return itemList.getItemDescription();
    }

    @Override
    public int getPrice() {
        return itemList.getPrice();
    }
}
