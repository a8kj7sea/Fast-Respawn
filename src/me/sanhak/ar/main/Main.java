package me.sanhak.ar.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import me.sanhak.ar.commands.ReloadCommand;
import me.sanhak.ar.listeners.PlayerDeath;

public class Main extends JavaPlugin {

	public static Main m;

	@Override
	public void onEnable() {
		m = this;
		Bukkit.getPluginManager().registerEvents(new PlayerDeath(), this);
		getCommand("frreload").setExecutor(new ReloadCommand());
		System.out.println("   ____         __    ___                              \r\n"
				+ "  / __/__ ____ / /_  / _ \\___ ___ ___  ___ __    _____ \r\n"
				+ " / _// _ `(_-</ __/ / , _/ -_|_-</ _ \\/ _ `/ |/|/ / _ \\\r\n"
				+ "/_/  \\_,_/___/\\__/ /_/|_|\\__/___/ .__/\\_,_/|__,__/_//_/\r\n"
				+ "                               /_/                     plugin has been enabled");
	}

	public static Main getMain() {
		return m;
	}

	@Override
	public void onDisable() {
		System.out.println("   ____         __    ___                              \r\n"
				+ "  / __/__ ____ / /_  / _ \\___ ___ ___  ___ __    _____ \r\n"
				+ " / _// _ `(_-</ __/ / , _/ -_|_-</ _ \\/ _ `/ |/|/ / _ \\\r\n"
				+ "/_/  \\_,_/___/\\__/ /_/|_|\\__/___/ .__/\\_,_/|__,__/_//_/\r\n"
				+ "                               /_/                     plugin has been disabled");
	}

}
