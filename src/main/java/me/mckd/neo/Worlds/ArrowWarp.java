package me.mckd.neo.Worlds;

import me.mckd.neo.Neo;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.block.Sign;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;

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
        if (eve.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow) eve.getEntity();
            Player p = (Player) eve.getEntity().getShooter();
            Location loc = arrow.getLocation();
            p.teleport(loc);
        }
    }

    @EventHandler
    public void signClick(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        Block b = e.getClickedBlock();
        World w = p.getWorld();
        if(
            p.getWorld().getName().equals("arrow") &&
            e.getAction().equals(Action.RIGHT_CLICK_BLOCK) &&
            b.getType() == Material.SIGN_POST)
        {
            Sign sign = (Sign) b.getState();
            String line = sign.getLine(1);
            if( line.equals("STAGE 1")) {
                Location loc = new Location(w, 100,20, 100);
                p.teleport(loc);
            }
        }
    }
}