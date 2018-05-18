package org.academiadecodigo.stormrooters.moneybank;

public class Person {

    private String personName;
    private Wallet myWallet;
    private Bank bank;


    public void spendMoney(int value) {
        System.out.println("    Product cost €" + value);
        myWallet.walletWithdraw(value);
    }

    public void bankToPocket(int valueToWithDraw) {
        myWallet.depositWallet(bank.bankWithdraw(valueToWithDraw));
        System.out.println("I withdrew €" + valueToWithDraw + " from Bank to Wallet");
        System.out.println("Current bank balance €" + bank.getBankBalance());
        System.out.println("Current wallet balance €" + myWallet.getWalletBalance());

    }


    //GETTERS AND SETTERS


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
