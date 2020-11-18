package Company;

import java.util.ArrayList;
import java.util.TreeSet;

public class Company {
    public ArrayList<Employee> employeesList = new ArrayList<Employee>();
    public double inCome;

    public Company(){
    //
    }

    public void hire(Employee employee){
        this.employeesList.add(employee);
    }

    public void hireAll(ArrayList<Employee> employees){
        for (Employee employee : employees){
            this.employeesList.add(employee);
        }
    }

    public void fire(int index){
        employeesList.remove(index);
    }

    public double getInCome() {
        return inCome;
    }

    public void setInCome(double inCome) {
        this.inCome = inCome;
    }

    public void getMonthSalary(){
        for (Employee employee : employeesList){
            System.out.println(employee.getMonthSalary());
        }
    }
    public TreeSet<Employee> getTopSalaryStaff(int count){
        TreeSet <Employee> topSalaryStaff = new TreeSet<Employee>(new EmployeeComparator());
        employeesList.sort(new EmployeeComparator());
        int i = 0;
        for (Employee employee : employeesList){
            if (i == count) {
                break;
            }
            topSalaryStaff.add(employee);
            i++;
        }

        return topSalaryStaff;
    }

    public TreeSet<Employee> getLowestSalaryStaff(int count){

        employeesList.sort((o1, o2) -> {
            if (o1.getMonthSalary() > o2.getMonthSalary()) {
                return 1;
            }
            if (o1.getMonthSalary() < o2.getMonthSalary()){
                return  -1;
            }
            return 0;
        });

        int i = 0;
        TreeSet <Employee> lowestSalaryStaff = new TreeSet<Employee>(new EmployeeComparator());
        for (Employee employee : employeesList){
            if (i == count) {
                break;
            }
            lowestSalaryStaff.add(employee);
            i++;
        }

        return lowestSalaryStaff;
    }

}
