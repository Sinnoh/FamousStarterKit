package me.sinnoh.FamousStarterKit;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.Material;

public class FSKConfig 
{
	public static FamousStarterKit plugin = FamousStarterKit.instance;
	
	
	public static void loadConfig()
	{
		File configfile = new File(plugin.getDataFolder(), "config.yml");
		if(!configfile.exists())
		{
			plugin.log.info("[FamousStarterKit] Creating a config file...");
		}
		plugin.getConfig().options().header("Format: ItemID:DataValue,Amount");
		plugin.getConfig().options().copyDefaults(true);
		plugin.saveConfig();
	}
	
	
	


}
