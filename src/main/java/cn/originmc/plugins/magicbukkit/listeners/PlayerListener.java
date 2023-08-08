package cn.originmc.plugins.magicbukkit.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.HashMap;
import java.util.Map;

public class PlayerListener implements Listener {
    //监听玩家交互事件
    @EventHandler
    public void onPlayerInteractEvent(PlayerInteractEvent event){
        Map<String,Object> objectMap=new HashMap<>();
        Map<String,Object> variableMap=new HashMap<>();
        objectMap.put("player",event.getPlayer());
        variableMap.put("action",event.getAction().name());
        objectMap.put("block",event.getClickedBlock());
    }
}
