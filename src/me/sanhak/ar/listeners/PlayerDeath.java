package me.sanhak.ar.listeners;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import me.sanhak.ar.configuration.Configuration;
import me.sanhak.ar.main.Main;

public class PlayerDeath implements Listener {

	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e) {

		Player target = e.getEntity();

		Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getMain(), new Runnable() {

			@SuppressWarnings("deprecation")

			public void run() {

				if (Configuration.getConfiguration().getBoolean("Options.Sound")) {

					target.playSound(target.getLocation(),
							Sound.valueOf(
									Configuration.getConfiguration().getString("Fast-Respawn.Sound").toUpperCase()),
							5.0f, 10.0f);

				}

				if (Configuration.getConfiguration().getBoolean("Options.Title")) {

					target.sendTitle(
							ChatColor.translateAlternateColorCodes('&',
									Configuration.getConfiguration().getString("Fast-Respawn.Title.Line1")),
							ChatColor.translateAlternateColorCodes('&',
									Configuration.getConfiguration().getString("Fast-Respawn.Title.Line2")));

				}

				target.spigot().respawn();

			}
		}, 0);
	}

}
