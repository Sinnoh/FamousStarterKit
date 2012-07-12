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
	
	
	public static void download() throws IOException
	{
	BufferedInputStream in = new BufferedInputStream(new URL("http://famousserver.de/test.txt").openStream());
	FileOutputStream fos = new FileOutputStream(plugin.getDataFolder() + "/test.txt");
	BufferedOutputStream bout = new BufferedOutputStream(fos,1024);
	byte data[] = new byte[1024];
			while(in.read(data,0,1024)>=0)
			{
				bout.write(data);
			}
			bout.close();
			in.close();
	}
	


}
