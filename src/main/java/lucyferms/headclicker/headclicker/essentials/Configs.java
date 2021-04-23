package lucyferms.headclicker.headclicker.essentials;

import lucyferms.headclicker.headclicker.HeadClicker;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Configs {


    private static HeadClicker plugin = HeadClicker.getPlugin();

    public static YamlConfiguration load(String configName){

        YamlConfiguration conf;
        File file = new File(plugin.getDataFolder() + File.separator + configName);

        if(!(file.exists())){
            plugin.saveResource(configName, false);
        }

        conf = new YamlConfiguration();

        try {

            conf.load(file);

        } catch (IOException e) {
            e.printStackTrace();
            return null;

        } catch (InvalidConfigurationException e) {
            e.printStackTrace();
            return null;
        }


        return conf;
    }


    public static void save(YamlConfiguration conf, String file){

        try {
            conf.save(new File(plugin.getDataFolder(), file));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
