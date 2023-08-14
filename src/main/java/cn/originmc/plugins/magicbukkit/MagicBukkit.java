package cn.originmc.plugins.magicbukkit;

import cn.origincraft.magic.MagicManager;
import cn.originmc.plugins.magicbukkit.commands.MagicBukkitCommand;
import cn.originmc.plugins.magicbukkit.data.SpellData;
import cn.originmc.plugins.magicbukkit.listeners.PlayerListener;
import cn.originmc.plugins.magicbukkit.magic.MainContext;
import cn.originmc.plugins.magicbukkit.magic.function.SendToMessage;
import org.bukkit.plugin.java.JavaPlugin;


public final class MagicBukkit extends JavaPlugin {
    private static JavaPlugin instance;
    private static MagicManager magicManager;

    public static JavaPlugin getInstance() {
        return instance;
    }

    public static MagicManager getMagicManager() {
        return magicManager;
    }


    @Override
    public void onEnable() {
        instance = this;
        magicManager=new MagicManager();
        MainContext.init();
        SpellData.load();
        getCommand("magicbukkit").setExecutor(new MagicBukkitCommand());
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        saveResource("spells/example.yml", false);
        getMagicManager().getFastExpression().getFunctionManager().register(new SendToMessage());
    }

    @Override
    public void onDisable() {

    }


}
