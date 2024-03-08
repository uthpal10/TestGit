package genericRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class DatabaseUtils 
{
	Connection con = null;
	
	public void connectToDB() throws SQLException
	{
		// To register database
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		con = DriverManager.getConnection(IpathConstants.DBURL, IpathConstants.DBUserName, IpathConstants.DBPassword);
	}
	
	public void executeAndGetData(String query, int colIndex, String expData) throws SQLException
	{
		Statement stmnt = con.createStatement();
		ResultSet result = stmnt.executeQuery(query);
		
		boolean flag = false;
		
		while(result.next())
		{
			String actualData = result.getString(colIndex);
			if(actualData.equalsIgnoreCase(expData))
			{
				flag = true;
				break;
			}
		}
		if(flag==true)
		{
			System.out.println("---- Data is present ----");
		}
		else
		{
			System.out.println("---- Data is not present ----");
		}
	}
	
	public void disconnectDB() throws SQLException
	{
		con.close();
	}	
}
