package org.academiadecodigo.stormrooters.moneyinthebank;

public class Main {

    public static void main(String[] args) {


        Bank bank = new Bank(100);

        Wallet myWallet = new Wallet();

        Person person = new Person("fabio",myWallet,bank);

        person.deposit(200);
        System.out.println(bank.getBankBalance());

    }


}
