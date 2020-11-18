package Clients;

public class Entity extends Client {
    private final double WITHDRAW_COMISSION = 0.01;


    @Override
    public void findOutTheBalance() {
        System.out.println("Снятие с коммисией 1%");
        super.findOutTheBalance();
    }

    @Override
    public void withdraw(double amount) {
        amount = amount + getWithdrawalComission(amount);
        super.withdraw(amount);
    }

    @Override
    protected double getWithdrawalComission(double amount) {
        return amount*WITHDRAW_COMISSION;
    }

    @Override
    protected double getDepositComission(double amount) {
        return 0;
    }
}
