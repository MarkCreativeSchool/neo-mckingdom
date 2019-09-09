package me.mckd.neo;

import me.mckd.neo.Worlds.ArrowWarp;
import me.mckd.neo.Worlds.LobbyWorld;
import org.bukkit.plugin.java.JavaPlugin;

public final class Neo extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        new LobbyWorld(this);
        new ArrowWarp(this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
