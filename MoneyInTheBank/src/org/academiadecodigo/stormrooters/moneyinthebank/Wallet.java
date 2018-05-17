package org.academiadecodigo.stormrooters.moneyinthebank;

public class Wallet {


    private int walletBalance;


    public int giveMoney(int withdraw) {
        walletBalance -= withdraw;
        return withdraw;
    }

    public int deposit(int deposit) {

        return walletBalance += deposit;
    }


    public int getBankBalance() {
        return walletBalance;
    }

    //public void setBankBalance(int bankBalance) {
    //    this.walletBalance = bankBalance;
    //}


}
