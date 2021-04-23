package lucyferms.headclicker.headclicker.listeners;

import lucyferms.headclicker.headclicker.Storage;
import lucyferms.headclicker.headclicker.essentials.ChatUtils;
import lucyferms.headclicker.headclicker.essentials.ConfigSave;
import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.block.Skull;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.meta.FireworkMeta;


public class HeadClickListener implements Listener {

    @EventHandler
    public static void onClickOnHead(PlayerInteractEvent event){
        Player player = event.getPlayer();

        if( event.getAction().equals(Action.RIGHT_CLICK_BLOCK)){
            if( event.getClickedBlock().getType().equals(Material.PLAYER_HEAD) || event.getClickedBlock().getType().equals(Material.PLAYER_WALL_HEAD)){
                Block headBlock = event.getClickedBlock();
                BlockState blockState = headBlock.getState();
                Skull skull = (Skull) blockState;


                skull.getOwningPlayer();
                if( Storage.listOfUUIDs.contains(skull.getOwningPlayer().getUniqueId())){
                    event.setCancelled(true);
                    headBlock.setType(Material.AIR);
                    Location location = headBlock.getLocation();
                    Firework fw = (Firework) location.getWorld().spawnEntity(location, EntityType.FIREWORK);
                    FireworkMeta fwm = fw.getFireworkMeta();
                    FireworkEffect effect =  FireworkEffect.builder().flicker(true).withColor(Color.AQUA).withFade(Color.RED).with(FireworkEffect.Type.CREEPER).trail(true).build();
                    fwm.addEffect(effect);
                    fwm.setPower(1);
                    fw.setFireworkMeta(fwm);
                    for( Player p : Bukkit.getOnlinePlayers() ){
                        p.sendMessage(ChatUtils.fixColor("&a" + player.getName() + " znalazl/a glowe!"));
                    }
                    if( Storage.top.containsKey(player.getName()) ){
                        int points = Storage.top.get(player.getName()) + 1;
                        Storage.top.remove(player.getName());
                        Storage.top.put(player.getName(), points);
                    }
                    else{
                        Storage.top.put(player.getName(), 1);
                    }
                    ConfigSave.saveTop();
                }
            }
        }

    }


}