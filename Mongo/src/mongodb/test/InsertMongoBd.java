package mongodb.test;

import com.mongodb.BasicDBObject;

public class InsertMongoBd {
	
	
	public static void insertMongoDb(String ins) {
		
		BasicDBObject doc = new BasicDBObject();
		doc.put("name", ins);
		ReadMongoColl.table.insert(doc);
			
	}

}
