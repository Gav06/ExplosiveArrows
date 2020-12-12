package me.gav06.arrow;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

public class ArrowCollideEvent implements Listener {
    /*
    TODO
    - add a configuration option for the explosions to ignore the player that fired the arrow
     
     */


    //getting custom user variables from configuration file
    int power = Main.getPlugin().getConfig().getInt("explosion-power");
    boolean isFireOn = Main.getPlugin().getConfig().getBoolean("explosion-fire");

    //calling event for when a block is shot
    @EventHandler
    public void onArrowHit(ProjectileHitEvent e) {
        //checking if the projectile is just a normal arrow
        if (e.getEntity().getType().equals(EntityType.ARROW)) {
            //getting arrow hit position
            if (e.getEntity().getLocation() != null) {
                Location blockPos = e.getEntity().getLocation();
                spawnExplosion(blockPos);
                e.getEntity().remove();
            }
        }
    }

    //calling event for when an entity is shot
    @EventHandler
    public void onEntityShot(EntityDamageByEntityEvent e) {
        if (e.getDamager().getType().equals(EntityType.ARROW)) {
            Location locale = e.getEntity().getLocation();
            spawnExplosion(locale);
            e.getDamager().remove();
        }
    }

    public void spawnExplosion(Location loc) {
        loc.getWorld().createExplosion(loc,power,isFireOn);
    }
}
