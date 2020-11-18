package Clients;

public abstract class Client {
    private double amount;

    public void depositToAccount(double amount){
        this.amount += amount;
    }
    public void withdraw(double amount){
        this.amount -= amount;
    }
    public void findOutTheBalance(){
        System.out.println("Баланс = "+amount);
    }
    protected abstract double getWithdrawalComission(double amount);

    protected abstract double getDepositComission(double amount);
}
