package lucyferms.headclicker.headclicker;

import lucyferms.headclicker.headclicker.commands.TopCommand;
import lucyferms.headclicker.headclicker.essentials.ConfigLoad;
import lucyferms.headclicker.headclicker.essentials.ConfigSave;
import lucyferms.headclicker.headclicker.listeners.HeadClickListener;
import org.bukkit.plugin.java.JavaPlugin;

public final class HeadClicker extends JavaPlugin {

    private static HeadClicker plugin;

    @Override
    public void onEnable() {
        plugin = this;
        ConfigLoad.loadAll();

        getCommand("hc").setExecutor(new TopCommand());
        getServer().getPluginManager().registerEvents(new HeadClickListener(), this);
        // Plugin startup logic

    }
    public static HeadClicker getPlugin(){
        return plugin;
    }

    @Override
    public void onDisable() {
        ConfigSave.saveAll();
        // Plugin shutdown logic
    }
}
