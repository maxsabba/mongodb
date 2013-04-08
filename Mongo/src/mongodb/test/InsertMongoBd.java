package mongodb.test;


import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.util.JSON;

public class InsertMongoBd {
	
	
	public static void insertMongoDb(String ins) {
//		System.out.println(ins);
		//BasicDBObject doc = new BasicDBObject("name", ins).append("type", "datadabse");
//		//doc.put("name", ins);
		DBObject doc = (DBObject)JSON.parse(ins);
		ReadMongoColl.readMongoColl();
		ReadMongoColl.table.insert(doc);
		
	}

}
