package com.example.mongodb;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import org.bson.Document;

public class MongoDbClient {
    public static void main(String[] args) {


        try {
            //链接mongodb服务
            MongoClient client = new MongoClient("localhost", 27017);
            //连接mongodb数据库
            MongoDatabase mongoDatabase = client.getDatabase("nanyan");
            MongoCollection<org.bson.Document> collection =mongoDatabase.getCollection("nanyan");
            System.out.println("集合 nanyan 选择成功");
            System.out.println("连接数据库成功");
            //查询数据库
            //更新数据库
            //FindIterable<Document> findIterable1= (FindIterable<Document>) collection.updateMany(Filters.eq("age", "0.2"), new Document("$set",new Document("age","1")));
            //删除一条记录
            collection.deleteOne(Filters.eq("age", "0.2"));
            //增加一条记录
            Document document = new Document("name", "nancaicai").append("age","4").append("type","2");
                    collection.insertOne(document);
            FindIterable<Document> findIterable =  collection.find();
            MongoCursor<org.bson.Document> mongoCursor = findIterable.iterator();
            while(mongoCursor.hasNext()){
                System.out.println(mongoCursor.next());
            }


        }catch (Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage());
        }


    }
}
