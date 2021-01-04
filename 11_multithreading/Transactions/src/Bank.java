import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Bank
{
    private HashMap<String, Account> accounts;
    private ArrayList<Integer> transferIds = new ArrayList<>();
    private final Random random = new Random();

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(HashMap<String, Account> accounts) {
        this.accounts = accounts;
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
    {   try {
        Thread.sleep(1000);
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
            Account fromAccount = accounts.get(fromAccountNum);
            Account toAccount = accounts.get(toAccountNum);

            if (transferIds.size() > 0) {
                transferIds.add(transferIds.get(transferIds.size() - 1) + 1);
            } else {
                transferIds.add(1);
            }
            int transferId = (transferIds.get(transferIds.size() - 1));

            if (fromAccountNum.equals(toAccountNum)) {
                System.out.println(transferId + " - " + "Нельзя переводить с одного и того же счета");
                return;
            }

        System.out.println(transferId + " - " + "Попытка перевода со счета " + fromAccount.getAccNumber() + " (" + fromAccount.getMoney() + ")"
                + " на счет " + toAccount.getAccNumber() + " (" + toAccount.getMoney() + ")"
                + " в размере " + Long.toString(amount));

            synchronized (fromAccount) {
                synchronized (toAccount) {
                    if (fromAccount.isBlock()) {
                        System.out.println(transferId + " - " + "Счет " + fromAccountNum + " заблокирован");
                        return;
                    }

                    if (toAccount.isBlock()) {
                        System.out.println(transferId + " - " + "Счет " + toAccountNum + " заблокирован");
                        return;
                    }

                    if (amount > 50000) {
                        if (isFraud(fromAccountNum, toAccountNum, amount)) {
                            fromAccount.setBlock(true);
                            toAccount.setBlock(true);
                            System.out.println(transferId + " - " + "Счета " + fromAccountNum + ", " + toAccountNum + " заблокированы после проверки службой безопасности");
                            return;
                        }
                    }
                    toAccount.toDeposit(amount);
                    fromAccount.withdraw(amount);

                    System.out.println(transferId + " - " + "Перевод успешен! Счет " + fromAccount.getAccNumber() + " - " + fromAccount.getMoney() + " счет " + toAccount.getAccNumber() + " - " + toAccount.getMoney());
                }
            }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum)
    {
        return accounts.get(accountNum).getMoney();
    }
}
