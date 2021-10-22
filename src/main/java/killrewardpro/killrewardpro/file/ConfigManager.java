package killrewardpro.killrewardpro.file;

import killrewardpro.killrewardpro.KillRewardPro;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    private KillRewardPro killReward;

    private File file;
    private YamlConfiguration config;

    public ConfigManager(KillRewardPro killReward){
        this.killReward = killReward;
    }

    public void loadConfig()  {

        file = new File(killReward.getDataFolder(), "config.yml");

        if(!(file.exists())){
            try{
                file.createNewFile();
            }catch(IOException ex){}

            config = YamlConfiguration.loadConfiguration(file);

            config.set("command.killer", "eco give <killer> 100");
            config.set("command.player", "eco take <player> 50");

            try {
                config.save(file);
            } catch (IOException e) {}

        }
    }

    public String getKillerCommand(){
        file = new File(killReward.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(file);

        return config.getString("command.killer");
    }

    public String getPlayerCommand(){
        file = new File(killReward.getDataFolder(), "config.yml");
        config = YamlConfiguration.loadConfiguration(file);

        return config.getString("command.player");
    }


}
