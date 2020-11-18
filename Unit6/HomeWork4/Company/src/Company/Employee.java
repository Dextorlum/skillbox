package Company;

public abstract class Employee {
    public double salary = 0.0;
    public double bonusPercent = 0.0;

    public double getMonthSalary() {
        return 0;
    }
    public void setSalary(double salary){
        this.salary = salary;
    }
    public void setBonusPercent(double percent){
        this.bonusPercent = percent;
    }
}
