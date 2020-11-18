package Company;

public class Manager extends Employee{
    private double amountMoneyEarned = 0.0;

    public Manager(){
        bonusPercent = 0.05;
        salary = Math.round(100000 + Math.random()*10000);
        amountMoneyEarned = Math.round(115000 + Math.random()*25000);
    }

    public void setAmountMoneyEarned(double amountMoneyEarned) {
        this.amountMoneyEarned = amountMoneyEarned;
    }

    @Override
    public double getMonthSalary() {
        return this.salary + amountMoneyEarned * bonusPercent;
    }
}
