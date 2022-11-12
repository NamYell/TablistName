import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("Plugin has been enabled.");
        getCommand("name").setExecutor(new command());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled.");
    }

}
