import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class onQuitEvent implements Listener {

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e) {
        FileConfiguration file = main.data.getConfig();

        if (DataManager.getData().contains("data")) {

            file.getConfigurationSection("data").getKeys(false).forEach(username -> {

                String str = file.getString("data." + username + ".uuid");

                if (str.equalsIgnoreCase(e.getPlayer().getUniqueId().toString())) {

                    String rank = file.getString("data." + username + ".rank");

                    if (rank.equalsIgnoreCase("op")) {
                        e.setQuitMessage(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + file.getString("data." + username + ".name") + " " + ChatColor.YELLOW +
                                "quit the game");

                    } else if (rank.equalsIgnoreCase("yt")) {
                        e.setQuitMessage(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                                " " + ChatColor.RED + file.getString("data." + username + ".name") + " " + ChatColor.YELLOW +
                                "quit the game");

                    } else if (rank.equalsIgnoreCase("player")) {
                        e.setQuitMessage(ChatColor.YELLOW + file.getString("data." + username + ".name") + " " +
                                ChatColor.YELLOW + "quit the game");

                    }

                }

            });
        }

    }

}
