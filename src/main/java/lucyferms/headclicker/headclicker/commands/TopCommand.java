package lucyferms.headclicker.headclicker.commands;

import lucyferms.headclicker.headclicker.Storage;
import lucyferms.headclicker.headclicker.essentials.ChatUtils;
import lucyferms.headclicker.headclicker.essentials.ConfigLoad;
import lucyferms.headclicker.headclicker.essentials.ConfigSave;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class TopCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if( args.length == 0 ){
            ConfigSave.saveTop();
            sender.sendMessage(ChatUtils.fixColor("&6&lTop 10 szukajacych"));
            int i = 1;
            for( String pName : Storage.top.keySet() ){
                sender.sendMessage(ChatUtils.fixColor( "&a" + i + ". " + pName + ": " + Storage.top.get(pName) ));
                if( i == 10 ){
                    break;
                }
                i++;
            }
        }
        else if( args[0].equalsIgnoreCase("reload")){
            ConfigLoad.loadAll();
        }
        else if( args[0].equalsIgnoreCase("save")){
            ConfigSave.saveAll();
        }
        else{
            sender.sendMessage(ChatUtils.fixColor("&c/" + label));
        }




        return true;
    }
}
