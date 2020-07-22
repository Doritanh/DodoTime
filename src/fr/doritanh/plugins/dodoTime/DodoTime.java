package fr.doritanh.plugins.dodoTime;

import org.bukkit.plugin.java.JavaPlugin;

public class DodoTime extends JavaPlugin {
	
	@Override
    public void onEnable() {
    	this.getServer().getPluginManager().registerEvents(new PlayerBedEnterListener(), this);
    }
    
    @Override
    public void onDisable() {

    }
	
}
