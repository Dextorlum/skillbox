package Clients;

public class Individual extends Client{

    @Override
    protected double getWithdrawalComission(double amount) {
        return 0;
    }

    @Override
    protected double getDepositComission(double amount) {
        return 0;
    }
}
