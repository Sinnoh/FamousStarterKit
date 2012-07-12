package me.sinnoh.FamousStarterKit;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;


public class FSKSQLlite 
{
	
	
	
	public static FamousStarterKit plugin = FamousStarterKit.instance;
	
	
	
	public static void createdefaultdatabase() throws SQLException
	{
		File db = new File(plugin.getDataFolder(), "players.db");
		if(!db.exists())
		{
			db.getParentFile().mkdir();
			Connection con =  DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() + "/players.db");
			Statement st = con.createStatement();
			st.executeUpdate("CREATE TABLE IF NOT EXISTS players(Name, Date);");
			st.close();
			con.close();
		}
	}
	
	
	public static void addplayer(String playername)
	{
		try
		{
			Connection con =  DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() + "/players.db");
			Statement st = con.createStatement();
			Date d = new Date();
			SimpleDateFormat dateformat = new SimpleDateFormat("dd.MM.yyyy, HH.mm");
			String date = dateformat.format(d);
			st.executeUpdate("INSERT INTO players VALUES('"+playername+"','"+date+"');");
			st.close();
			con.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static Boolean checkplayer(String playername)
	{
		try
		{
			Connection con =  DriverManager.getConnection("jdbc:sqlite:" + plugin.getDataFolder() + "/players.db");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT Name FROM players");
			while(rs.next())
			{
				if(rs.getString(1).equals(playername) && rs != null)
				{
					return true;
				}
			}
			return false;
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return false;
	}

}
