package org.academiadecodigo.stormrooters.snackbar;

public enum Food {

    SANDUICHE("Sanduiche", 3.00),
    HOTDOG("Hot Dog", 4.00),
    HAMBURGUER("Hamburguer", 4.70);

    private String name;
    private double price;

    private Food(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public double getPrice() {
        return this.price;
    }

    public static void showMenu() {

        System.out.println("FOOD MENU");

        for (Food items : Food.values()) {
            System.out.println( "   " + items.getName()+ " at "+ items.getPrice()+" €");
        }

    }
}
