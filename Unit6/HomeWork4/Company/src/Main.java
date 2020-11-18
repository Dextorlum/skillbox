import Company.*;

import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();
        company.setInCome(11000000);
        for (int i = 0; i < 10; i++){
            Employee employee = new TopManager(company);
            company.hire(employee);
        }

        for (int i = 0; i < 80; i++){
            Employee employee = new Manager();
            company.hire(employee);
        }
        for (int i = 0; i < 180; i++){
            Employee employee = new Operator();
            company.hire(employee);
        }


       // company.getMonthSalary();
        System.out.println("Топ 10 самых высоких зарплат");

        for (Employee employee : company.getTopSalaryStaff(15)){
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("Топ 30 самых низких зарплат зарплат");

        for (Employee employee : company.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("Увольняем половину сотрудников");
        int index = company.employeesList.size()/2;
        for (int i = 0; i < index; i++){
            company.fire(i);
        }

        System.out.println("Топ 10 самых высоких зарплат");

        for (Employee employee : company.getTopSalaryStaff(15)){
            System.out.println(employee.getMonthSalary());
        }

        System.out.println("Топ 30 самых низких зарплат зарплат");

        for (Employee employee : company.getLowestSalaryStaff(30)){
            System.out.println(employee.getMonthSalary());
        }

    }
}
