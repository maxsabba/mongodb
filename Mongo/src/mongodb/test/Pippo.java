package mongodb.test;

import com.mongodb.BasicDBObject;


public class Pippo {

	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i=0; i < 1000000; i++) {
			String s = "Massimo" + i;
			pippo(s);
		}
		
	}
	
	
	public static void pippo(String ins) {
		System.out.println(ins);
		BasicDBObject doc = new BasicDBObject("name", ins).append("type", "datadabse");
		//		//doc.put("name", ins);
//		DBObject doc = (DBObject)JSON.parse(ins);
						
		
			ReadMongoColl.readMongoColl();
			ReadMongoColl.table.insert(doc);
//			MongoConnect.mongoConnect();
//			MongoConnect.end();
				
	}
	
	

}
