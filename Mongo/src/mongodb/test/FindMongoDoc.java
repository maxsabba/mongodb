package mongodb.test;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;

public class FindMongoDoc {
	
public static String findMongoDoc(String str) {
		String name = null;
	    /** execute a query inside the collection select **/
	
		BasicDBObject query = new BasicDBObject();
		query.put("name", str);
		ReadMongoColl.readMongoColl();
		DBCursor cursor = ReadMongoColl.table.find(query);
		
		
		if (cursor.hasNext()) {
			name = query.getString("name");
				// System.out.println(cursor.next());
				//System.out.println(name);
								
		} else {
			name = "Not found:";
			//System.out.println("Not found:");
		}
		
		/**** Done ****/
		
		//cursor.close();
		return name;
	}

}
