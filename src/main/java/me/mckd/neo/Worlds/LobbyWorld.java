package me.mckd.neo.Worlds;

import me.mckd.neo.Neo;
import org.bukkit.event.Listener;

public class LobbyWorld implements Listener {

    public LobbyWorld(Neo plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }
}
