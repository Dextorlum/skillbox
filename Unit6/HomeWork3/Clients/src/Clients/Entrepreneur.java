package Clients;

public class Entrepreneur extends Client{
    private final double DEPOSIT_COMISSION_FIRST = 0.01;
    private final double DEPOSIT_COMISSION_SECOND = 0.005;

    @Override
    public void findOutTheBalance() {
        System.out.println("Пополнение с комиссией 1%, если сумма меньше 1000 рублей.");
        System.out.println("И с комиссией 0.5%, если сумма большо либо равна 1000");
        super.findOutTheBalance();
    }

    @Override
    public void depositToAccount(double amount) {
        amount = amount - getDepositComission(amount);
        super.depositToAccount(amount);
    }

    @Override
    protected double getWithdrawalComission(double amount) {
        return 0;
    }

    @Override
    protected double getDepositComission(double amount) {
        if (amount < 1000){
            return amount * DEPOSIT_COMISSION_FIRST;
        } else {
           return amount * DEPOSIT_COMISSION_SECOND;
        }
    }
}
