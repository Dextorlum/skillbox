package Accounts;

public class CardAccount extends MainAccount{
    private final double WITHDRAW_COMMISSION = 0.01;

    @Override
    public void withdraw(double amount) {
        amount = amount + getWithdrawalComission(amount);
        super.withdraw(amount);
    }

    @Override
    protected double getWithdrawalComission(double amount) {
        return amount*WITHDRAW_COMMISSION;
    }

    @Override
    protected double getDepositComission(double amount) {
        return 0;
    }
}
