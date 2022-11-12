import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

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

                DataManager.getData().set("data." + p.getUniqueId() + ".name", strings[0]);

            } else {

                if (strings[1].equalsIgnoreCase("op")) {
                    if (p.isOp()) {
                        p.setPlayerListName(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + strings[0]);
                        p.setDisplayName(ChatColor.GOLD + "[" + ChatColor.WHITE + "OP" + ChatColor.GOLD + "]" +
                                " " + ChatColor.GOLD + strings[0]);

                    } else {
                        p.sendMessage("This command is only allowed to SERVER OP!");

                    }

                } else if (strings[1].equalsIgnoreCase("yt")) {
                    p.setPlayerListName(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                            " " + ChatColor.RED + strings[0]);
                    p.setDisplayName(ChatColor.RED + "[" + ChatColor.WHITE + "YT" + ChatColor.RED + "]" +
                            " " + ChatColor.RED + strings[0]);

                } else if (strings[1].equalsIgnoreCase("player")) {
                    p.setPlayerListName(ChatColor.WHITE + strings[0]);
                    p.setDisplayName(strings[0]);

                }

            }

            return true;
        } else {

            commandSender.sendMessage("This command is only allowed to the players");

            return false;
        }
    }

}
