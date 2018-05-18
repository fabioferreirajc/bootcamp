public class bankpackage org.academiadecodigo.stormrooters.moneyinthebank;

public class Bank {


    private int bankBalance;

    public Bank(int bankBalance) {
        this.bankBalance = bankBalance;
    }

    public int withdraw(int withdraw) {
        return bankBalance -= withdraw;
    }

    public int deposit(int deposit) {
        System.out.println("Extraordinary deposit €" + (bankBalance+deposit));
        return bankBalance += deposit;
    }


    //GETTERS AND SETTERS
    public int getBankBalance() {
        return bankBalance;
    }


}

