package Accounts;

public class BankAccount extends  MainAccount {

    @Override
    protected double getWithdrawalComission(double amount) {
        return 0;
    }

    @Override
    protected double getDepositComission(double amount) {
        return 0;
    }
}
