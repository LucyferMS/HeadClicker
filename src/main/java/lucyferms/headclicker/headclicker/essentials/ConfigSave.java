package lucyferms.headclicker.headclicker.essentials;

import lucyferms.headclicker.headclicker.Storage;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ConfigSave {

    public static void saveAll(){
        saveTop();
    }

    public static void saveTop(){
        sortTop();
        YamlConfiguration top = Configs.load("top.yml");
        for( String pName : Storage.top.keySet() ){
            assert top != null;
            top.set("top." + pName, Storage.top.get(pName));
        }
        assert top != null;
        Configs.save(top, "top.yml");
    }

    public static void sortTop(){
        //Sortowanie topki
    }


}
