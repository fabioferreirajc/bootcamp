package org.academiadecodigo.stormrooters.moneybank;


public class Bank {


    private int bankBalance;

    public Bank(int bankBalance) {
        System.out.println("BANK ACCOUNT " + "Fabio Ferreira");
        this.bankBalance = bankBalance;
        System.out.println("Current bank balance €" + bankBalance);
    }

    /*
    public int bankWithdraw(int withdraw) {
        if (bankBalance >= withdraw) {
            bankBalance -= withdraw;
            System.out.println("Withdrew from bank " + withdraw);
            return withdraw;
        }
        return 0;
    }*/


    public int bankWithdraw(int withdraw) {
        if (withdraw >= bankBalance) {
            System.out.println("No money in the bank");
            return 0;
        }
        bankBalance-=withdraw;
        return withdraw;


    }


    public void deposit(int deposit) {
        System.out.println("Extraordinary deposit €" + (deposit));
        bankBalance += deposit;
        System.out.println("Current bank balance €" + bankBalance);
    }


    //GETTERS AND SETTERS
    public int getBankBalance() {
        return bankBalance;
    }


}

