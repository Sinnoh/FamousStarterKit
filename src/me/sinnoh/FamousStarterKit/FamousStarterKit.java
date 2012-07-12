package me.sinnoh.FamousStarterKit;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Logger;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;

public class FamousStarterKit extends JavaPlugin
{
	
	
	public static FamousStarterKit instance;
	public static Logger log = Logger.getLogger("Minecraft");
	public FSKListener listener = new FSKListener(this);

	public void onDisable()
	{
		
	}
	
	public void onEnable()
	{
		instance = this;
		FSKConfig.loadConfig();
		try {
			FSKSQLlite.createdefaultdatabase();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		getServer().getPluginManager().registerEvents(listener, this);
		try {
			FSKConfig.download();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	@Override
	public boolean onCommand(CommandSender sender, Command command,String label, String[] args) 
	{
		if(args.length == 1)
		{
			if(command.getName().equalsIgnoreCase("add"))
			{
				FSKSQLlite.addplayer(args[0]);
				return true;
			}
			if(command.getName().equalsIgnoreCase("check"))
			{
				if(FSKSQLlite.checkplayer(args[0]))
				{
					System.out.println("true");
					return true;
				}
				else
				{
					System.out.println("false");
					return true;
				}
			}
		}
		return false;
	}
}
