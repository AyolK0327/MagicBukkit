package cn.originmc.plugins.magicbukkit.magic;

import cn.origincraft.magic.object.ContextMap;

import java.util.HashMap;
import java.util.Map;

public class MainContext implements ContextMap {
    private static Map<String,Object> mainObjectMap;
    private static Map<String,Object> mainVariableMap;
    public static void init(){
        mainObjectMap=new HashMap<>();
        mainVariableMap=new HashMap<>();
    }

    public static Map<String, Object> getMainObjectMap() {
        return mainObjectMap;
    }

    public static void setMainObjectMap(Map<String, Object> mainObjectMap) {
        MainContext.mainObjectMap = mainObjectMap;
    }

    public static Map<String, Object> getMainVariableMap() {
        return mainVariableMap;
    }

    public static void setMainVariableMap(Map<String, Object> mainVariableMap) {
        MainContext.mainVariableMap = mainVariableMap;
    }

    @Override
    public Map<String, Object> getObjectMap() {
        return getMainObjectMap();
    }

    @Override
    public Map<String, Object> getVariableMap() {
        return getMainVariableMap();
    }

    @Override
    public void putObject(String s, Object o) {
        getMainObjectMap().put(s,o);
    }

    @Override
    public void putVariable(String s, Object o) {
        getMainVariableMap().put(s,o);
    }

    @Override
    public void setObjectMap(Map<String, Object> map) {
        setMainObjectMap(map);
    }

    @Override
    public void setVariableMap(Map<String, Object> map) {
        setMainVariableMap(map);
    }
}
