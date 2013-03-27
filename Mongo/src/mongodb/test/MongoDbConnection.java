package mongodb.test;

import java.net.UnknownHostException;


import com.mongodb.Mongo;
import com.mongodb.MongoException;
import com.mongodb.DB;



public class MongoDbConnection {
	public static Mongo mongo;
	public static DB database;
	
	public static void momgoDbConnectios() {	
		 try {
			//connect to the database
			    	mongo=new Mongo("localhost" , 27017 );
			//get tutorials database
			            database=mongo.getDB("mydb");
			        } catch (UnknownHostException ex) {
			           ex.printStackTrace();
			        } catch (MongoException ex) {
			            ex.printStackTrace();
			        }
			    }
	}
		
//	}
//	
//	private static  DB database;
//    static{
//       
////get collection from database
//    public static DBCollection getCollection(String collectionName){
//        return database.getCollection(collectionName);
//    }
//
//}
