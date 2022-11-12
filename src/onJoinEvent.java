import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class onJoinEvent implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e) {

        FileConfiguration file = main.data.getConfig();

        if (DataManager.getData().contains("data")) {

            file.getConfigurationSection("data").getKeys(false).forEach(username -> {

                String str = file.getString("data." + username + ".uuid");

                if (str.equalsIgnoreCase(e.getPlayer().getUniqueId().toString())) {

                    String rank = file.getString("data." + username + ".rank");

                    if (rank.equalsIgnoreCase("op")) {
                        e.getPlayer().setPlayerListName(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + file.getString("data." + username + ".name"));
                        e.getPlayer().setDisplayName(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + file.getString("data." + username + ".name"));

                        e.setJoinMessage(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + file.getString("data." + username + ".name") + " " + ChatColor.YELLOW +
                                "joined the game");

                    } else if (rank.equalsIgnoreCase("yt")) {
                        e.getPlayer().setPlayerListName(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                                " " + ChatColor.RED + file.getString("data." + username + ".name"));
                        e.getPlayer().setDisplayName(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                                " " + ChatColor.RED + file.getString("data." + username + ".name"));

                        e.setJoinMessage(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                                " " + ChatColor.RED + file.getString("data." + username + ".name") + " " + ChatColor.YELLOW +
                                "joined the game");

                    } else if (rank.equalsIgnoreCase("player")) {
                        e.getPlayer().setPlayerListName(ChatColor.WHITE + file.getString("data." + username + ".name"));
                        e.getPlayer().setDisplayName(file.getString("data." + username + ".name"));

                        e.setJoinMessage(ChatColor.YELLOW + file.getString("data." + username + ".name") + " " +
                                ChatColor.YELLOW + "joined the game");

                    }

                }

            });
        }

    }

}
