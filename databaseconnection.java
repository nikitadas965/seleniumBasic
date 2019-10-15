package resources;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class databaseconnection {
	
	private Connection connection;
	private ResultSet rs;
	private Statement st;

	@BeforeClass
	public void setup()
	{
		String dburl="jdbc:mysql://localhost:3306/easy";
		String username="root";
		String password="pass";
		connection=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("connecting to db");
			connection=DriverManager.getConnection(dburl,username,password);
			if(connection!=null)
			{
				System.out.println("connected");
			}
		}
		catch(SQLException e){
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test
	public void  getData()
	{
		try
		{
			String query="Select * from Employee";
			st=connection.createStatement();
			rs=st.executeQuery(query);
			while(rs.next())
			{
				int id=rs.getInt("EmpId");
				String name=rs.getString(2);
				Double sal=rs.getDouble("Salary");
				System.out.println(id+name+sal);
			}
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	@AfterClass
	public void tearDown()
	{
		try{
		if(connection!=null){
			connection.close();
		}
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}
}
