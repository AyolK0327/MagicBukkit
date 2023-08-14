package cn.originmc.plugins.magicbukkit.commands;

import cn.origincraft.magic.object.ContextMap;
import cn.originmc.plugins.magicbukkit.MagicBukkit;
import cn.originmc.plugins.magicbukkit.data.SpellData;
import cn.originmc.plugins.magicbukkit.data.object.TriggeribleSpell;
import cn.originmc.plugins.magicbukkit.magic.MainContext;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MagicBukkitCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length==0){
            sender.sendMessage("§c§lMagicBukkit §7- §fMagicBukkit is a plugin that allows you to use MagicSpells in Bukkit.");
            sender.sendMessage("§c§lMagicBukkit §7- §fUse §c/magicbukkit help §fto view the help.");
            return true;
        }
        if (args[0].equalsIgnoreCase("help")){
            sender.sendMessage("§c§lMagicBukkit §7- §fMagicBukkit is a plugin that allows you to use MagicSpells in Bukkit.");
            sender.sendMessage("§c§lMagicBukkit §7- §fUse §c/magicbukkit help §fto view the help.");
            sender.sendMessage("§c§lMagicBukkit §7- §fUse §c/magicbukkit reload §fto reload the config.");
            return true;
        }
        if (args[0].equalsIgnoreCase("reload")){
            SpellData.load();
            MagicBukkit.getInstance().reloadConfig();
            return true;
        }else if (args[0].equalsIgnoreCase("execute")){
            if (args.length<2){
                sender.sendMessage("§c§lMagicBukkit §7- §fUse §c/magicbukkit execute <spell> §fto execute a spell.");
                return true;
            }
            TriggeribleSpell spell=SpellData.getSpellByName(args[1]);
            if (spell==null){
                sender.sendMessage("§c§lMagicBukkit §7- §fThe spell §c"+args[1]+" §fdoes not exist.");
                return true;
            }
            MainContext mainContext=new MainContext();
            if (sender instanceof Player){
                mainContext.putObject("player",sender);
            }else {
                mainContext.putObject("sender",sender);
            }
            spell.execute(new MainContext());
            return true;
        }
        return true;
    }
}
