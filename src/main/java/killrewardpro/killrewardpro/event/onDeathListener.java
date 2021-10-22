package killrewardpro.killrewardpro.event;

import killrewardpro.killrewardpro.file.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class onDeathListener implements Listener {

    private ConfigManager configManager;
    public onDeathListener(ConfigManager configManager){
        this.configManager = configManager;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){

        if(e.getEntity() instanceof Player){
            //getting the player
            Player player = (Player) e.getEntity();

            if(player.getKiller() instanceof Player){
                //getting the killer
                Player killer = player.getKiller();

                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), configManager.getKillerCommand().replaceFirst("<killer>", killer.getName()));
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), configManager.getPlayerCommand().replaceFirst("<player>", player.getName()));

            }
        }
    }

}
