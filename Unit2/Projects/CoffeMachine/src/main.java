public class main {
    public static void main(String[] args) {
        int moneyAmount = 15;

        int cappucinoPrice = 180;
        int lattePrice = 120;
        int espressoPrice = 80;
        int waterPrice = 20;

        boolean canBuyAnything = false;
        boolean isMilkEnough = false;

        boolean moneyEnoughForCappucino = moneyAmount >= cappucinoPrice;

        if (moneyEnoughForCappucino && isMilkEnough) {
            System.out.println("Вы можете купить капучино");
            canBuyAnything = true;
        }

        if (moneyAmount >= lattePrice && isMilkEnough) {
            System.out.println("Вы можете купить латте");
            canBuyAnything = true;
        }

        if (moneyAmount >= espressoPrice) {
            System.out.println("Вы можете купить эспрессо");
            canBuyAnything = true;
        }

        if (moneyAmount >= waterPrice) {
            System.out.println("Вы можете купить воду");
            canBuyAnything = true;
        }


            System.out.println(canBuyAnything ? "Выберите напиток" : "Недастаточно средств");


    }
}
