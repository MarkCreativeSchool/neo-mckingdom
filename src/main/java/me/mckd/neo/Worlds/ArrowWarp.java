package me.mckd.neo.Worlds;

import me.mckd.neo.Neo;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowWarp implements Listener {

    public ArrowWarp(Neo plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void arrowshot(ProjectileHitEvent eve) {
        World world = eve.getEntity().getWorld();
        if (!world.getName().equals("arrow")) {
            return;
        }
        if (eve.getEntity()instanceof Arrow)  {
            Arrow arrow = (Arrow)eve.getEntity();
            Location loc = arrow.getLocation();
            Player p = (Player)eve.getEntity().getShooter();
            p.teleport(loc);
        }
    }
}
