import Accounts.BankAccount;
import Accounts.CardAccount;
import Accounts.DepositAccount;

public class Main {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        DepositAccount depositAccount = new DepositAccount();
        CardAccount cardAccount = new CardAccount();

        bankAccount.depositToAccount(1000);
        depositAccount.depositToAccount(2000);
        cardAccount.depositToAccount(3000);
        cardAccount.withdraw(100);

        System.out.println("Банковский счет = "+bankAccount.getAmount());
        System.out.println("Депозитный счет = "+depositAccount.getAmount());
        System.out.println("Карточный счет = "+cardAccount.getAmount());
        System.out.println("Перевод с банковского на депозитный счет");
        if (bankAccount.send(depositAccount, 100)){
            System.out.println("Деньги переведены");
        }
        System.out.println("Банковский счет = "+bankAccount.getAmount());
        System.out.println("Депозитный счет = "+depositAccount.getAmount());

    }
}
