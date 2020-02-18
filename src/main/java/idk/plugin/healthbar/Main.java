package idk.plugin.healthbar;

import cn.nukkit.player.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.NukkitRunnable;

public class Main extends PluginBase {

    public void onEnable() {
        getServer().getScheduler().scheduleDelayedRepeatingTask(this, new NukkitRunnable() {

            @Override
            public void run() {
                try {
                    for (Player p : getServer().getOnlinePlayers().values()) {
                        StringBuilder str = new StringBuilder();

                        int i = 0;
                        float hp = p.getHealth();
                        int maxHp = p.getMaxHealth();
                        while (i < maxHp) {
                            if (hp > i) {
                                str.append("\u00A7a|");
                            } else {
                                str.append("\u00A7c|");
                            }
                            i++;
                        }

                        String s = str.toString();
                        if (!p.getScoreTag().equals(s)) {
                            p.setScoreTag(s);
                        }
                    }
                } catch (Exception ignore) {}
            }
        }, 10, 10, true);
    }
}
