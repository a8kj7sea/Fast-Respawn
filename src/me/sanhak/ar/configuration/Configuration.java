package me.sanhak.ar.configuration;

import java.io.File;
import java.io.IOException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Configuration {

	private static File file;
	private static FileConfiguration fileConfiguration;

	public Configuration(JavaPlugin plugin, String configurationName, boolean saveDefault) {
		Configuration.file = new File(plugin.getDataFolder(), configurationName);
		Configuration.file.getParentFile().mkdirs();
		if (!file.exists()) {
			if (saveDefault) {
				plugin.saveResource(configurationName, true);
			} else {
				try {
					file.createNewFile();
				} catch (IOException var5) {
					var5.printStackTrace();
				}
			}
		}
		Configuration.fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}

	public static FileConfiguration getConfiguration() {
		return fileConfiguration;
	}

	public static void reload() {
		Configuration.fileConfiguration = YamlConfiguration.loadConfiguration(file);
	}

	public static void save() {
		try {
			fileConfiguration.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
