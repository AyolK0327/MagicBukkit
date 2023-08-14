package cn.originmc.plugins.magicbukkit.magic;

import cn.origincraft.magic.object.ContextMap;

import java.util.concurrent.ConcurrentHashMap;

public class MainContext implements ContextMap {
    private static ConcurrentHashMap<String, Object> mainObjectMap;
    private static ConcurrentHashMap<String, Object> mainVariableMap;
    public static void init(){
        mainObjectMap=new ConcurrentHashMap<>();
        mainVariableMap=new ConcurrentHashMap<>();
    }


    public static ConcurrentHashMap<String, Object> getMainObjectMap() {
        return mainObjectMap;
    }

    public static void setMainObjectMap(ConcurrentHashMap<String, Object> mainObjectMap) {
        MainContext.mainObjectMap = mainObjectMap;
    }

    public static ConcurrentHashMap<String, Object> getMainVariableMap() {
        return mainVariableMap;
    }

    public static void setMainVariableMap(ConcurrentHashMap<String, Object> mainVariableMap) {
        MainContext.mainVariableMap = mainVariableMap;
    }

    @Override
    public ConcurrentHashMap<String, Object> getObjectMap() {
        return mainObjectMap;
    }

    @Override
    public ConcurrentHashMap<String, Object> getVariableMap() {
        return mainVariableMap;
    }

    @Override
    public void putObject(String s, Object o) {
        mainObjectMap.put(s,o);
    }

    @Override
    public void putVariable(String s, Object o) {
        mainVariableMap.put(s,o);
    }

    @Override
    public void setObjectMap(ConcurrentHashMap<String, Object> concurrentHashMap) {
        setMainObjectMap(concurrentHashMap);
    }

    @Override
    public void setVariableMap(ConcurrentHashMap<String, Object> concurrentHashMap) {
        setMainVariableMap(concurrentHashMap);
    }
}
