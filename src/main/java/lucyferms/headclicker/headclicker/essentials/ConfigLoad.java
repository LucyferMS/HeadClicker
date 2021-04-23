package lucyferms.headclicker.headclicker.essentials;

import lucyferms.headclicker.headclicker.Storage;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConfigLoad {

    public static void loadAll(){
        load();
        loadHeadUUIDs();
        loadTop();
    }



    public static void load(){
        YamlConfiguration configuration = Configs.load("config.yml");
        assert configuration != null;
        Configs.save(configuration, "config.yml");
    }

    public static void loadHeadUUIDs(){
        YamlConfiguration conf = Configs.load("headUUIDs.yml");
        List<String> list;
        assert conf != null;
        list = conf.getStringList("heads");
        for( String l : list ){
            Storage.listOfUUIDs.add(UUID.fromString(l));
        }
    }

    public static void loadTop(){
        YamlConfiguration top = Configs.load("top.yml");
        Storage.top.clear();
        assert top != null;
        for( String pName : top.getConfigurationSection("top").getKeys(false)){
            Storage.top.put(pName, top.getInt("top." + pName) );
        }
    }
}
