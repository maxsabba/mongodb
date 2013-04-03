package mongodb.test;

import mongodb.test.FindMongoDoc;
import mongodb.test.InsertMongoBd;
 

public class AppDue {
	
	public static void main(String[] args) {
		
//		/** excute the query **/
		String str = "massimo";
//		FindMongoDoc.findMongoDoc(str);
//		/** insert a document **/
		String ins = "Massimo Sabbadini tre";
		InsertMongoBd.insertMongoDb(ins);
		/** find the last document added **/
		str = ins;
		FindMongoDoc.findMongoDoc(str);
//		System.out.println(InsertRecordIntoTable.insertRecord());
	  
	  }
 
}
