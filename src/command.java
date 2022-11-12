import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import java.util.*;

public class command implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {

            Player p = (Player) commandSender;

            if (strings.length == 0) {
                p.sendMessage("Enter /name <nickname>");

            } else if (strings.length == 1) {

                p.setPlayerListName(ChatColor.WHITE + strings[0]);
                p.setDisplayName(strings[0]);

                List<String> uuid = new ArrayList<>();

                FileConfiguration file = main.data.getConfig();

                if (DataManager.getData().contains("data")) {

                    file.getConfigurationSection("data").getKeys(false).forEach(username -> {

                        String str = file.getString("data." + username + ".uuid");

                        if (str.equalsIgnoreCase(p.getUniqueId().toString())) {
                            file.set("data." + username + ".name", strings[0]);
                        }

                        uuid.add(str);

                    });
                }

                if (!uuid.contains(p.getUniqueId().toString())) {
                    DataManager.getData().set("data." + p.getName() + ".uuid", p.getUniqueId().toString());
                    DataManager.getData().set("data." + p.getName() + ".name", strings[0]);
                    DataManager.getData().set("data." + p.getName() + ".rank", "player");
                }

                DataManager.saveData();

            } else {

                if (strings[1].equalsIgnoreCase("op")) {
                    if (p.isOp()) {
                        p.setPlayerListName(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + strings[0]);
                        p.setDisplayName(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + strings[0]);

                        List<String> uuid = new ArrayList<>();

                        FileConfiguration file = main.data.getConfig();

                        if (DataManager.getData().contains("data")) {

                            file.getConfigurationSection("data").getKeys(false).forEach(username -> {

                                String str = file.getString("data." + username + ".uuid");

                                if (str.equalsIgnoreCase(p.getUniqueId().toString())) {
                                    file.set("data." + username + ".name", strings[0]);
                                    file.set("data." + username + ".rank", "op");
                                }

                                uuid.add(str);

                            });
                        }

                        if (!uuid.contains(p.getUniqueId().toString())) {
                            DataManager.getData().set("data." + p.getName() + ".uuid", p.getUniqueId().toString());
                            DataManager.getData().set("data." + p.getName() + ".name", strings[0]);
                            DataManager.getData().set("data." + p.getName() + ".rank", "op");
                        }

                        DataManager.saveData();

                    } else {
                        p.sendMessage("This command is only allowed to SERVER OP!");

                    }

                } else if (strings[1].equalsIgnoreCase("yt")) {
                    p.setPlayerListName(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                            " " + ChatColor.RED + strings[0]);
                    p.setDisplayName(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                            " " + ChatColor.RED + strings[0]);

                    List<String> uuid = new ArrayList<>();

                    FileConfiguration file = main.data.getConfig();

                    if (DataManager.getData().contains("data")) {

                        file.getConfigurationSection("data").getKeys(false).forEach(username -> {

                            String str = file.getString("data." + username + ".uuid");

                            if (str.equalsIgnoreCase(p.getUniqueId().toString())) {
                                file.set("data." + username + ".name", strings[0]);
                                file.set("data." + username + ".rank", "yt");
                            }

                            uuid.add(str);

                        });
                    }

                    if (!uuid.contains(p.getUniqueId().toString())) {
                        DataManager.getData().set("data." + p.getName() + ".uuid", p.getUniqueId().toString());
                        DataManager.getData().set("data." + p.getName() + ".name", strings[0]);
                        DataManager.getData().set("data." + p.getName() + ".rank", "yt");
                    }

                    DataManager.saveData();

                } else if (strings[1].equalsIgnoreCase("player")) {
                    p.setPlayerListName(ChatColor.WHITE + strings[0]);
                    p.setDisplayName(strings[0]);

                    List<String> uuid = new ArrayList<>();

                    FileConfiguration file = main.data.getConfig();

                    if (DataManager.getData().contains("data")) {

                        file.getConfigurationSection("data").getKeys(false).forEach(username -> {

                            String str = file.getString("data." + username + ".uuid");

                            if (str.equalsIgnoreCase(p.getUniqueId().toString())) {
                                file.set("data." + username + ".name", strings[0]);
                                file.set("data." + username + ".rank", "player");
                            }

                            uuid.add(str);

                        });
                    }

                    if (!uuid.contains(p.getUniqueId().toString())) {
                        DataManager.getData().set("data." + p.getName() + ".uuid", p.getUniqueId().toString());
                        DataManager.getData().set("data." + p.getName() + ".name", strings[0]);
                        DataManager.getData().set("data." + p.getName() + ".rank", "player");
                    }

                    DataManager.saveData();

                }

            }

            return true;
        } else {

            commandSender.sendMessage("This command is only allowed to the players");

            return false;
        }
    }

}
