package Accounts;

public abstract class MainAccount {
    private double amount;

    public MainAccount (){
        //Констуктор
        this.amount = 0;
    }

    public void depositToAccount(double amount){
        this.amount += amount;
    }

    public void withdraw(double amount){
        this.amount -= amount;
    }

    public boolean send(MainAccount receiver, double amount){
        double receiverAmount = receiver.getAmount();
        receiver.depositToAccount(amount);
        this.withdraw(amount);

        if (receiverAmount < receiver.getAmount()){
            return true;
        } else {
            return false;
        }
    }
    public double getAmount() {
        return amount;
    }
    protected abstract double getWithdrawalComission(double amount);
    protected abstract double getDepositComission(double amount);
}
