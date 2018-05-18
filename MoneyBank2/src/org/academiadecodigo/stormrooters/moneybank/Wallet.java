package org.academiadecodigo.stormrooters.moneybank;

public class Wallet {


    private int walletBalance;

    //METHODS



    public void walletWithdraw(int withdraw) {
        if (withdraw > walletBalance) {
            System.out.println("    No money in wallet.");
            System.out.println("    I need to go to the bank!!!");
            return; // out of method if there is no money in wallet
        }
        walletBalance -= withdraw;
        System.out.println("    Money spend €" + withdraw);
        System.out.println("    Money in wallet after spent €" + walletBalance);


    }



    public void depositWallet(int deposit) {
        System.out.println(walletBalance);
        walletBalance += deposit;
        System.out.println("    Wallet balance is " + walletBalance);
    }


    //GETTERS AND SETTERS

    public int getWalletBalance() {
        return walletBalance;
    }


}

