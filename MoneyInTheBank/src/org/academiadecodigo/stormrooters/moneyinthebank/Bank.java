package org.academiadecodigo.stormrooters.moneyinthebank;

public class Bank {

    public Bank ( int bankBalance) {
        this.bankBalance=bankBalance;

    }


    private int bankBalance;




    public int giveMoney(int withdraw) {

        return bankBalance -= withdraw;
    }

    public int deposit(int deposit) {

        return bankBalance += deposit;
    }



    public int getBankBalance() {
        return bankBalance;
    }

    public void setBankBalance(int bankBalance) {
        this.bankBalance = bankBalance;
    }
}
