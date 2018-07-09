package org.academiadecodigo.stormrooters;

public class Apple extends ItemList {

    public Apple(CashRegister item) {
        super(item);
    }

    @Override
    public String getItemDescription() {
        return itemList.getItemDescription()+"apple";
    }

    @Override
    public int getPrice() {
        return itemList.getPrice()+2;
    }

}
