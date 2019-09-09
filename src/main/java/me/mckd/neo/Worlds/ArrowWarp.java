package me.mckd.neo.Worlds;

import me.mckd.neo.Neo;
import org.bukkit.event.Listener;

public class ArrowWarp implements Listener {

    public ArrowWarp(Neo plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
