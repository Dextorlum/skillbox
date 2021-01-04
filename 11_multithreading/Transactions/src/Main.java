import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Bank bank = new Bank();
        HashMap<String, Account>  accounts = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            accounts.put(Integer.toString(i), new Account((long) (Math.random() * 10000000), Integer.toString(i)));
        }

        bank.setAccounts(accounts);


        for (int i = 1; i <= 5; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    String acountFrom = Integer.toString((int) (Math.random() * bank.getAccounts().size()) + 1);
                    String acountTo = Integer.toString((int) (Math.random() * bank.getAccounts().size()) + 1);
                    try {
                        bank.transfer(acountFrom, acountTo, (long) (Math.random() * 100000));
                    } catch (Exception ex) {
                        System.out.println("Ошибка при переводе со счета " + acountFrom + "на счет " + acountTo
                                );
                        ex.printStackTrace();
                    }
                }
            });
            t.start();
        }


    }
}
