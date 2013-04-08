package mongodb.test;

import mongodb.test.MongoConnect;

import com.mongodb.DBCollection;

public class ReadMongoColl {
	
	/** find the document inside the correct collection **/

public static DBCollection table;

	public static void readMongoColl() {
		MongoConnect.mongoConnect();
		table = MongoConnect.db.getCollection("pippo");
	}

}
