package org.academiadecodigo.stormrooters.moneyinthebank;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

public class Main {

    public static void main(String[] args) {


        Bank bank = new Bank(0);
        Wallet myWallet = new Wallet();
        //System.out.println("Inicial money in wallet €" + myWallet.getWalletBalance());

        Person person = new Person();
        person.setPersonName("Fábio Ferreira");
        person.setBank(bank);
        person.setMyWallet(myWallet);

        System.out.println("BANK ACCOUNT " + person.getPersonName());

        bank.deposit(1333);
        System.out.println("Current bank balance €" + bank.getBankBalance());


        myWallet.walletBalance(100);
        person.spendMoney(120);


        //System.out.println(person.getMyWallet());
        //System.out.println(person.getBank());


    }


}
