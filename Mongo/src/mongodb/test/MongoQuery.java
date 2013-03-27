package mongodb.test;



import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class MongoQuery {
	 
		public static void mongoQuery() {
			DBCollection coll = MongoDbConnection.database.getCollection("things");
			
			BasicDBObject query  = new BasicDBObject();
			String queryResult;
			String s = "massimo";
			query.put("name", s);
			
			DBCursor cursor = coll.find(query);
			
			while (cursor.hasNext()){
					queryResult = query.getString("name");
					System.out.println(queryResult);
				} 
				cursor.close();
			}
		
		public static void main(String[] args) {
			
			mongoQuery();
		}
		
}

		

