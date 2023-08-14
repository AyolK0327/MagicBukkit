package cn.originmc.plugins.magicbukkit.data.object;

import cn.origincraft.magic.object.ContextMap;
import cn.origincraft.magic.object.Spell;
import cn.originmc.plugins.magicbukkit.MagicBukkit;
import cn.originmc.plugins.magicbukkit.magic.MainContext;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TriggeribleSpell {
    private String name;
    private String trigger;
    private List<String> magicWords;
    public TriggeribleSpell() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTrigger() {
        return trigger;
    }

    public void setTrigger(String trigger) {
        this.trigger = trigger;
    }

    public List<String> getMagicWords() {
        return magicWords;
    }

    public void setMagicWords(List<String> magicWords) {
        this.magicWords = magicWords;
    }

    public boolean execute(ContextMap contextMap) {
        if (magicWords != null) {
            if (!magicWords.isEmpty()) {
                Spell spell = new Spell(magicWords, MagicBukkit.getMagicManager());
                spell.execute(contextMap);
                return true;
            }
        }
        return false;
    }
}
