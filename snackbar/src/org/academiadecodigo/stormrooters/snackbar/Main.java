package org.academiadecodigo.stormrooters.snackbar;

public class Main {

    public static void main(String[] args) {

        Drink.showMenu();
        Food.showMenu();
        Drink clientChoiceDrink;
        Food clientChoiceFood;

        Client newClient = new Client();

        clientChoiceDrink = newClient.clientchoice(Drink.WATER);
        clientChoiceFood = newClient.clientchoice2(Food.HAMBURGUER);

        System.out.println("ClIENT CHOICE:");

        System.out.println("   " + clientChoiceDrink.getName() + " " + clientChoiceDrink.getPrice() + " €");
        System.out.println("   " + clientChoiceFood.getName() + " " + clientChoiceFood.getPrice() + " €");

        System.out.println("TOTAL " + (clientChoiceDrink.getPrice() + clientChoiceFood.getPrice()) + " €");


    }
}
