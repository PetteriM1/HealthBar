package idk.plugin.healthbar;

import cn.nukkit.Player;
import cn.nukkit.plugin.PluginBase;
import cn.nukkit.scheduler.NukkitRunnable;

public class Main extends PluginBase {

    public void onEnable() {
        getServer().getScheduler().scheduleDelayedRepeatingTask(this, new NukkitRunnable() {

            @Override
            public void run() {
                for (Player p : getServer().getOnlinePlayers().values()) {
                    StringBuilder str = new StringBuilder();

                    int i = 0;
                    while (i < p.getMaxHealth()) {
                        if (p.getHealth() > i) {
                            str.append("\u00A7a|");
                        } else {
                            str.append("\u00A7c|");
                        }
                        i++;
                    }

                    p.setScoreTag(str.toString());
                }
            }
        }, 10, 10);
    }
}
