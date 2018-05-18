package org.academiadecodigo.stormrooters.moneyinthebank;

public class Person {

    private String personName;
    private Wallet myWallet;
    private Bank bank;

    /*
    CONSTRUCTOR
    public Person ( String personName, Wallet myWallet, Bank bank) {
        this.personName=personName;
        this.myWallet=myWallet;
        this.bank=bank;
    }*/
    /*
    public void depositWallet(int value) {
        bank.deposit(myWallet.giveMoney(value));
    }
    */


    public void spendMoney(int value) {
        if (myWallet.getWalletBalance() > value) {
            myWallet.giveMoney(value);
            System.out.println("Money spend €" + value);
            System.out.println("    Money in wallet after spent €" + myWallet.getWalletBalance());

        }


        if (myWallet.getWalletBalance() < value) {
            System.out.println("No money!");
            myWallet.depositWallet(bank.withdraw(myWallet.getWalletBalance()-value));
        }

    }


    //GETTERS AND SETTERS

    public String getPersonName() {
        return this.personName;
    }

    public Wallet getMyWallet() {
        return this.myWallet;
    }

    public Bank getBank() {
        return this.bank;
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
