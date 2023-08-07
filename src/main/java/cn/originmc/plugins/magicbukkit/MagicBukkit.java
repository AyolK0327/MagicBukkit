package cn.originmc.plugins.magicbukkit;

import cn.origincraft.magic.MagicManager;
import cn.originmc.plugins.magicbukkit.data.SpellData;
import cn.originmc.plugins.magicbukkit.listeners.PlayerListener;
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
        SpellData.load();
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
    }

    @Override
    public void onDisable() {

    }


}
