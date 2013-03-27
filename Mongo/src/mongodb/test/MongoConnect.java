package mongodb.test;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;

public class MongoConnect {

/** connect to the selected db **/	
	
public static DB db;
	public static void mongoConnect() {
		try {
			MongoClient mongoCli = new MongoClient("localhost", 27017);
			db = mongoCli.getDB("mydb");
		} catch (UnknownHostException e) {
		e.printStackTrace();
	    } catch (MongoException e) {
		e.printStackTrace();
	    }

	}
}
