package mongodb.test;

import java.sql.*;


public class InsertRecordIntoTable {
	
	
	// variabili per MSSQL
	static Connection connection = null;
	static PreparedStatement ptmt = null;
	static ResultSet rs = null;
	static String json = null;
	
		
//	// MSSQL
	private static Connection getConnectionMSSQL() throws SQLException {
		Connection conn;
		conn = ConnectDb.getInstance().getConnectionMSSQL();
		return conn;
		}
		

	
	public static String insertRecord() {
		String queryString = "SELECT [filepath],[Codice Filiale],[Codice Prodotto],[Codice Subfiliale],[Numero Contratto],[Alphacode Cliente],[Data Liquidazione],[Carton ID],[File Folder] FROM [Citi].[dbo].[DataBase RV950045 Contratti Contratti Elettronici 18.07.21];";
		String a = "\'";
		try {
			// SELECT from MSSQL db			
			connection = getConnectionMSSQL();
			ptmt = connection.prepareStatement(queryString);
			rs = ptmt.executeQuery();
			while (rs.next()) {
				String field1=  a + "filepath" + a + ":" + a + rs.getString(1) + a;
				String field2 = a +"Codice Filiale"  +a + ":"+ a + rs.getString(2)+ a;
				String field3 = a + "Codice Prodotto"  +a + ":"+ a + rs.getString(3)+ a;
				String field4 = a + "Codice Subfiliale"  + a +":"+ a + rs.getString(4)+ a;
				String field5 = a +"Numero Contratto"  + a +":" + a+ rs.getString(5)+ a;
				String field6 = a +"Alphacode Cliente"  + a +":" + a+ rs.getString(6)+ a;
				String field7 = a +"Data Liquidazione"  + a +":" + a+ rs.getString(7)+ a;
				String field8 = a +"Carton ID"  + a + ":" + a+ rs.getString(8)+ a;
				String field9 = a +"File Folder"  + a + ":" + a+ rs.getString(9)+ a;
				
				json = "{" + field1 + "," 
						+ field2 + "," 
						+ field3+ ","
						+ field4+ "," 
						+ field5+ "," 
						+ field6+ "," 
						+ field7+ "," 
						+ field8+ "," 
						+ field9+ ","
						+"}";
				InsertMongoBd.insertMongoDb(json);
			} 
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
            try {
                if (rs != null)
                        rs.close();
                if (ptmt != null)
                        ptmt.close();
                if (connection != null)
                        connection.close();
               

                		
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (Exception e) {
                e.printStackTrace();
        }
		
		
	}
		return json;
	}	

}
