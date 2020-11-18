package Company;

public class Operator extends Employee{

    public Operator(){
        salary = Math.round(60000 + Math.random()*10000);
    }

    @Override
    public double getMonthSalary() {
        return this.salary;
    }
}
