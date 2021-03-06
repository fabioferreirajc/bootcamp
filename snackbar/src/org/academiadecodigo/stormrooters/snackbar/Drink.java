package org.academiadecodigo.stormrooters.snackbar;

public enum Drink {

    COCACOLA("Coca Cola", 2.20),
    JUICE("Natural Juice", 3.00),
    WATER("Water", 1.00);

    private String name;
    private double price;

    private Drink(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }



 Client client;
    public static void showMenu() {

        System.out.println("DRINKS MENU");

        for (Drink items : Drink.values()) {
            System.out.println( "   " + items.getName()+ " at "+ items.getPrice()+" €");
        }

    }
}




