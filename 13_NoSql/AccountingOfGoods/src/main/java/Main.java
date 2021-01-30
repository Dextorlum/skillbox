import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 3678);
        MongoDatabase mongoDatabase = mongoClient.getDatabase("Goods");

        AccountOfGoodsController accountOfGoodsController = new AccountOfGoodsController(mongoDatabase);
        for (;;) {
//            ДОБАВИТЬ_МАГАЗИН Девяточка
//            ДОБАВИТЬ_ТОВАР Вафли 54
//            ВЫСТАВИТЬ_ТОВАР Вафли Девяточка
//            СТАТИСТИКА_ТОВАРОВ
            System.out.println("Введите команду");
            Scanner scanner = new Scanner(System.in);
            String inCommand = scanner.nextLine();
            String[] subs = inCommand.split(" (?=([^\"]*\"[^\"]*\")*[^\"]*$)");

            accountOfGoodsController.setSubs(subs);


            if (inCommand.toUpperCase().contains("ДОБАВИТЬ_МАГАЗИН")) {
                accountOfGoodsController.addShop();
            } else if (inCommand.toUpperCase().contains("ДОБАВИТЬ_ТОВАР")) {
                accountOfGoodsController.addGoods();
            } else if (inCommand.toUpperCase().contains("ВЫСТАВИТЬ_ТОВАР")) {
                accountOfGoodsController.exhibitGoods();
            } else if (inCommand.toUpperCase().equals("СТАТИСТИКА_ТОВАРОВ")) {
                continue;
            } else {
                System.out.println("Команда указана неверно");
                continue;}

        }

        }

    }
