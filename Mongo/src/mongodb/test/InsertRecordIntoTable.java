package mongodb.test;

import java.sql.*;

import com.mongodb.BasicDBObject;


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
		
	/* find the recod inside a MSSQL db and write it to a mongo collection **/
	
	public static void  insertRecord() {
		String queryString = "SELECT [filepath],[Codice Filiale],[Codice Prodotto],[Codice Subfiliale],[Numero Contratto],[Alphacode Cliente],[Data Liquidazione],[Carton ID],[File Folder] FROM [Citi].[dbo].[DataBase RV950045 Contratti Contratti Elettronici 18.07.21];";
		int i = 0 ;
		try {
			// SELECT from MSSQL db			
			connection = getConnectionMSSQL();
			ptmt = connection.prepareStatement(queryString);
			rs = ptmt.executeQuery();
			while (rs.next()) {
			
				BasicDBObject document = new BasicDBObject();
				document.put("filepath" , rs.getString(1));
				document.put("Codice Filiale" , rs.getString(2));
				document.put("Codice Prodotto" , rs.getString(3));
				document.put("Codice Subfiliale"  , rs.getString(4));
				document.put("Numero Contratto" , rs.getString(5));
				document.put("Alphacode Cliente"  , rs.getString(6));
				document.put("Data Liquidazione"  , rs.getString(7));
				document.put("Carton ID" , rs.getString(8));
				document.put("File Folder" , rs.getString(9));
				
				if (ReadMongoColl.table == null) {
					ReadMongoColl.readMongoColl();
				}
				
				ReadMongoColl.table.insert(document);
				System.out.println(i++);
				
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
	}	

}
