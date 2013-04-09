package mongodb.test;

import mongodb.test.MongoConnect;

import com.mongodb.DBCollection;

public class ReadMongoColl {
	
	/** open the mongo collection **/

public static DBCollection table;

	public static void readMongoColl() {
		MongoConnect.mongoConnect();
		table = MongoConnect.db.getCollection("pippo");
	}

}
