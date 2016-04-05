package io.github.web.data.mongodb;

import java.util.Date;

import org.bson.Document;

import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class MongoDbExample {

    public static void main(String args[]) {
        MongoClient mongo = new MongoClient("localhost", 27017);
        MongoDatabase db = mongo.getDatabase("test");
        MongoCollection<Document> collection = db.getCollection("user");

        // Accessing MongoDB

        // Create
        Document document = new Document();
        document.put("name", "John Doe");
        document.put("age", 30);
        document.put("createdDate", new Date());
        collection.insertOne(document);

        // Read one
        BasicDBObject searchQuery = new BasicDBObject();
        searchQuery.put("name", "John Doe");
        FindIterable<Document> cursor = collection.find(searchQuery);
        System.out.println(cursor.first());

        // Update
        Document documentUpdate = new Document();
        documentUpdate.append("$set", new Document("age", 35));
        collection.updateOne(searchQuery, documentUpdate);
        System.out.println(collection.find(searchQuery).first());

        // Delete
        MongoCursor<Document> iterator = collection.find().iterator();
        while (iterator.hasNext()) {
            Document doc = iterator.next();
            collection.deleteOne(doc);
        }

        mongo.close();
    }
}
