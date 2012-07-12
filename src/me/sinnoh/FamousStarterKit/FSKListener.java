package me.sinnoh.FamousStarterKit;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;



import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public class FSKListener implements Listener
{
	
	private FamousStarterKit plugin;
	public FSKListener(FamousStarterKit instance)
	{
		plugin = instance;
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event)
	{
		Player player = event.getPlayer();
		if(FSKSQLlite.checkplayer(player.getName()))
		{
			return;
		}
		List<String> list = plugin.getConfig().getStringList("Items");
		for(String s : list)
		{
			String[] a = s.split(",");
			String[] b = a[0].split(":");
			int id = 0;
			int data = 0;
				if(b.length == 2)
				{
					 id = Integer.valueOf(b[0]);
					 data = Integer.valueOf(b[1]);
				}
				else
				{
					 id = Integer.valueOf(b[0]);
					 data = 0;
				}
			int amount = Integer.valueOf(a[1]);
			ItemStack item = new ItemStack(id, amount, (short) data);
			player.getInventory().addItem(item);
		}
		FSKSQLlite.addplayer(player.getName());
		
	}
	

}
