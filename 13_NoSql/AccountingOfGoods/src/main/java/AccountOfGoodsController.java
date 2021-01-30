import com.mongodb.BasicDBObject;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import org.bson.Document;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.Arrays;

import static com.mongodb.client.model.Filters.eq;
import static com.mongodb.client.model.Filters.gt;
import static com.mongodb.client.model.Updates.addToSet;

public class AccountOfGoodsController {


    private MongoDatabase mongoDatabase;
    private MongoCollection<Document> goods;
    private MongoCollection<Document> shops;
    private String[] subs;

    public String[] getSubs() {
        return subs;
    }

    public void setSubs(String[] subs) {
        this.subs = subs;
    }

    public AccountOfGoodsController(MongoDatabase mongoDatabase) {
        this.mongoDatabase = mongoDatabase;
        this.goods = mongoDatabase.getCollection("goods");
        this.shops = mongoDatabase.getCollection("shops");
    }

    public void addGoods() {
        Document document = new Document();
        document.append("name", subs[1]);
        document.append("price", subs[2]);

        goods.insertOne(document);
        System.out.println(document.toString());
    }
    public void addShop() {
        Document document = new Document();
        document.append("name", subs[1]);
        document.append("goods", new ArrayList<String>());

        shops.insertOne(document);
        System.out.println(document.toString());
    }

    public void exhibitGoods() {
        UpdateResult updateResult = shops.updateOne(eq("name", subs[1]),  addToSet("goods", subs[2]));
        System.out.println(updateResult.toString());
    }

    public void getStatsGoods(){

        FindIterable<Document> findIterable = goods.find(gt("price", 100));
        System.out.println(findIterable.cursor().);
    }

}
