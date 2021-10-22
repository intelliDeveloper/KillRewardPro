package killrewardpro.killrewardpro;

import killrewardpro.killrewardpro.event.onDeathListener;
import killrewardpro.killrewardpro.file.ConfigManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class KillRewardPro extends JavaPlugin {

    @Override
    public void onEnable() {

        register();

    }

    @Override
    public void onDisable() {


    }

    private void register(){

        ConfigManager config = new ConfigManager(this);
        config.loadConfig();

        Bukkit.getPluginManager().registerEvents(new onDeathListener(config), this);

    }

}
