package petterim1.healthbar;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;

public class Main extends PluginBase {

    public void onEnable() {
        getServer().getScheduler().scheduleDelayedRepeatingTask(this, () -> {
            try {
                for (Player p : getServer().getOnlinePlayers().values()) {
                    if (!p.spawned) {
                        continue;
                    }

                    StringBuilder str = new StringBuilder();

                    int i = 0;
                    float hp = p.getHealth();
                    int maxHp = p.getMaxHealth();
                    while (i < maxHp) {
                        if (hp > i) {
                            str.append("§a|");
                        } else {
                            str.append("§c|");
                        }
                        i++;
                    }

                    String s = str.toString();
                    if (!s.equals(p.getScoreTag())) {
                        p.setScoreTag(s);
                    }
                }
            } catch (Exception ignore) {}
        }, 5, 5, "IGN".equals(getServer().getCodename()));
    }
}
