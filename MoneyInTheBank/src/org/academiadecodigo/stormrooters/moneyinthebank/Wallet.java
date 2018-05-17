package org.academiadecodigo.stormrooters.moneyinthebank;

public class Wallet {


    private int walletBalance;

    public void walletBalance ( int walletBalance) {
        this.walletBalance=walletBalance;
    }

    public int giveMoney(int withdraw) {
        walletBalance -= withdraw;
        return withdraw;
    }

    public int depositWallet(int deposit) {
        return walletBalance += deposit;
    }

    public int getWalletBalance() {
        return walletBalance;
    }



}
