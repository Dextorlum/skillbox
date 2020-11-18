package Accounts;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class DepositAccount extends MainAccount {
    private Calendar lastEnterDate;

    public DepositAccount (){

    }
    @Override
    public void depositToAccount(double amount) {
        Calendar date = new GregorianCalendar();
        date.add(Calendar.MONTH, 1);
        lastEnterDate = date;
        super.depositToAccount(amount);
    }

    @Override
    public void withdraw(double amount) {
        Calendar currDate = new GregorianCalendar();
        if (currDate.after(lastEnterDate)) {
            super.withdraw(amount);
        } else {
            System.out.println("Невозможно снять деньги, т.к не прошел месяц с последнего зачисления.");
        }
    }

    @Override
    protected double getWithdrawalComission(double amount) {
        return 0;
    }

    @Override
    protected double getDepositComission(double amount) {
        return 0;
    }
}
