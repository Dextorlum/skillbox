import Clients.Client;
import Clients.Entity;
import Clients.Entrepreneur;
import Clients.Individual;

public class Main {
    public static void main(String[] args) {
        Client indiviual = new Individual();
        Client entity = new Entity();
        Client entrepreneur = new Entrepreneur();

        indiviual.depositToAccount(1000);
        indiviual.withdraw(100);
        indiviual.findOutTheBalance();

        entity.depositToAccount(1000);
        entity.withdraw(200);
        entity.findOutTheBalance();

        entrepreneur.depositToAccount(900);
        entrepreneur.findOutTheBalance();
        entrepreneur.depositToAccount(1000);
        entrepreneur.findOutTheBalance();


    }
}
