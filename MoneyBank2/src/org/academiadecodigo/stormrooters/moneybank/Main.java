package org.academiadecodigo.stormrooters.moneybank;

public class Main {

    public static void main(String[] args) {


        Bank bank = new Bank(0);
        Wallet myWallet = new Wallet();


        Person person = new Person();
        person.setPersonName("Fábio Ferreira");
        person.setBank(bank);
        person.setMyWallet(myWallet);



        bank.deposit(1333);

        myWallet.depositWallet(100);


        person.spendMoney(120);

        person.bankToPocket(200);


        //System.out.println(person.getMyWallet());
        //System.out.println(person.getBank());


    }
}
