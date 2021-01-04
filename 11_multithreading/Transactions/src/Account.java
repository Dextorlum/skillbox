public class Account
{
    private long money;
    private String accNumber;
    private volatile boolean block;

    public Account(long money, String accNumber) {
        this.money = money;
        this.accNumber = accNumber;
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public boolean isBlock() {
        return block;
    }

    public void setBlock(boolean block) {
        this.block = block;
    }
    public void toDeposit(long amount) {
        if (!this.isBlock()) {
            this.money += amount;
        }
    }
    public void withdraw (long amount){
        if (!this.isBlock()){
            this.money -= amount;
        }
    }


}
