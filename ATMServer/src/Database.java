import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class Database {

	
	
	
private static java.sql.Connection connect= null;
	
	
	
	public static  java.sql.Connection getDatabaseConnection() {
		try{
		 if (connect == null){
			 MysqlDataSource ds = new MysqlDataSource();
			 ds.setUser("root");
			 ds.setPassword("");
			 ds.setURL("jdbc:mysql://localhost/ATM");
			 connect =ds.getConnection();
			 return connect;
		
		
		 } else	{
		 
		return connect;
		 }
		}catch(Exception e){
			e.printStackTrace();
		}
		return connect;
	}
	
	
	
	
	
	
	
	
	
	
}
