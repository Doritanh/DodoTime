package fr.doritanh.plugins.dodoTime;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerBedEnterEvent;

public class PlayerBedEnterListener implements Listener {

	@EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
		if (!event.getBedEnterResult().toString().equals("OK")) {
            return;
        }
		Bukkit.broadcastMessage(event.getPlayer().getName() + " dort !");
//		final World world = event.getPlayer().getWorld();
//		world.setTime(0L);
//      world.setThundering(false);
//      world.setStorm(false);
        
        for(Player p : Bukkit.getOnlinePlayers()) {
        	p.setSleepingIgnored(true);
        }
	}
	
}
