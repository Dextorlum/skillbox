package Company;

public class TopManager extends Employee {
    public double companyIncome;
    public TopManager(Company company){
        this.bonusPercent = 1.5;
        this.companyIncome = company.inCome;
        this.salary = Math.round(150000 + Math.random()*10000);
    }

    @Override
    public double getMonthSalary() {
        if (companyIncome > 10000000) {
            return this.salary + this.salary*bonusPercent;
        } else {
            return this.salary;
        }
    }
}
