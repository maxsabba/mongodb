package mongodb.test;

import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.util.JSON;
 
/**
 * Java MongoDB : Insert a Document
 * 
 */
public class InsertDocumentApp {
  public static void main(String[] args) {
 
    try {
 
	Mongo mongo = new Mongo("localhost", 27017);
	DB db = mongo.getDB("mydb");
 
	DBCollection collection = db.getCollection("pippo");
 
	// 1. BasicDBObject example
	System.out.println("BasicDBObject example...");
	BasicDBObject document = new BasicDBObject();
//	document.put("database", "mkyongDB");
//	document.put("table", "hosting");
	  
	for (int i=0; i < 100; i++) {
		String n = "Max" + i;
		document.put("name", n + i);
	    collection.insert(document);
//	    System.out.println(n);
	}
	
//	collection.insert(document);
 
	DBCursor cursorDoc = collection.find();
	while (cursorDoc.hasNext()) {
		System.out.println(cursorDoc.next());
	}
 
//	collection.remove(new BasicDBObject());
 

    } catch (UnknownHostException e) {
	e.printStackTrace();
    } catch (MongoException e) {
	e.printStackTrace();
    }
 
  }
}