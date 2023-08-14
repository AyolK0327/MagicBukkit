package cn.originmc.plugins.magicbukkit.data;

import cn.originmc.plugins.magicbukkit.MagicBukkit;
import cn.originmc.plugins.magicbukkit.data.object.TriggeribleSpell;
import cn.originmc.tools.minecraft.yamlcore.object.YamlElement;
import cn.originmc.tools.minecraft.yamlcore.object.YamlManager;

import java.util.ArrayList;
import java.util.List;

public class SpellData {
    private static YamlManager yamlManager;
    private static List<TriggeribleSpell> spells=new ArrayList<>();
    public static void load() {
        spells.clear();
        yamlManager = new YamlManager(MagicBukkit.getInstance(),"spells",true);
        for (YamlElement yamlElement : yamlManager.getYamlElements()) {
            TriggeribleSpell triggeribleSpell = new TriggeribleSpell();
            triggeribleSpell.setName(yamlElement.getId());
            triggeribleSpell.setTrigger((String) yamlElement.get("trigger"));
            if (yamlElement.get("magicWords") instanceof List) {
                triggeribleSpell.setMagicWords((List<String>) yamlElement.get("magicWords"));
            }
            spells.add(triggeribleSpell);
        }

    }
    public static YamlManager getYamlManager() {
        return yamlManager;
    }

    public static List<TriggeribleSpell> getSpells() {
        return spells;
    }

    public static void setSpells(List<TriggeribleSpell> spells) {
        SpellData.spells = spells;
    }

    public static List<TriggeribleSpell> getSpellsByTrigger(String trigger) {
        for (TriggeribleSpell spell : spells) {
            if (spell.getTrigger().equalsIgnoreCase(trigger)) {
                return spells;
            }
        }
        return spells;
    }
    public static TriggeribleSpell getSpellByName(String name) {
        for (TriggeribleSpell spell : spells) {
            if (spell.getName().equalsIgnoreCase(name)) {
                return spell;
            }
        }
        return null;
    }
}
