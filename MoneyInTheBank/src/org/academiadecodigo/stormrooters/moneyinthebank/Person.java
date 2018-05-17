package org.academiadecodigo.stormrooters.moneyinthebank;

public class Person {

    private String personName;
    private Wallet myWallet;
    private Bank bank;

    public Person ( String personName, Wallet myWallet, Bank bank) {
        this.personName=personName;
        this.myWallet=myWallet;
        this.bank=bank;
    }

    public void deposit(int value) {

         bank.deposit(myWallet.giveMoney(value));
    }



    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public void setMyWallet(Wallet myWallet) {
        this.myWallet = myWallet;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }
}
