package mailprepare;
import java.io.FileInputStream;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

public class DatabaseJdbc {

	public String Dbconnection () {
		ResultSet rs = null;
		String tablename = "";
		
		
		
	try {
		
		Properties p = new Properties();
		FileInputStream is = new FileInputStream("config.properties");
		p.load(is); 
		String query = p.getProperty("sql");
		String forName = p.getProperty("forName");
		String dbcon = p.getProperty("dbcon");
		String user = p.getProperty("user");
		String pass = p.getProperty("pass");
		String prousr = p.getProperty("prouser");
		String procon = p.getProperty("procon");
		String propass = p.getProperty("propass");
		String prosql = p.getProperty("prosql");
		
		
		Class.forName(p.getProperty("forName"));
		Connection con = DriverManager.getConnection(  
			p.getProperty("procon"),p.getProperty("prouser"),p.getProperty("propass"));
	
		Statement st =con.createStatement(); 
		rs= st.executeQuery(p.getProperty("prosql"));
		while(rs.next()) {
			tablename = rs.getString("tablename") + " , \r\n " + tablename ;
		}  
		
		st.close();
		con.close();
	} catch (Exception e) {
		System.out.println("Dbconnection Exception -- ");
		e.printStackTrace();
	} 
	//System.out.println(tablename);
	return tablename;



	}	
	
	
	}
	

