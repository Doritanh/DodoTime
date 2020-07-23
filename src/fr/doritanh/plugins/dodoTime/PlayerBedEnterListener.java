package fr.doritanh.plugins.dodoTime;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

public class PlayerBedEnterListener implements Listener {
	
	private JavaPlugin plugin;
	
	public PlayerBedEnterListener(JavaPlugin plugin) {
		this.plugin = plugin;
	}
	
	@EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
		if (!event.getBedEnterResult().toString().equals("OK")
				|| !(event.getPlayer() instanceof Player)) {
            return;
        }
		Bukkit.broadcastMessage(ChatColor.AQUA + event.getPlayer().getName() + ChatColor.WHITE + " dort !");

		BukkitScheduler scheduler = Bukkit.getServer().getScheduler();
		
		ArrayList<Player> playersSleepNotIgnored = new ArrayList<Player>();
		
        scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
            @Override
            public void run() {
            	for (Player p : Bukkit.getOnlinePlayers()) {
            		if (!p.isSleepingIgnored()) {
            			playersSleepNotIgnored.add(p);
                		p.setSleepingIgnored(true);
            		}
            	}
            	
            	scheduler.scheduleSyncDelayedTask(plugin, new Runnable() {
                    @Override
                    public void run() {
                    	for (Player p : playersSleepNotIgnored) {
                    		p.setSleepingIgnored(false);
                    	}
                    	
                    	playersSleepNotIgnored.clear();
                    }
                }, 20);
            }
        }, 60);
	}
	
}
