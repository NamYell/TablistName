import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public static DataManager data;

    @Override
    public void onEnable() {

        data = new DataManager(this);

        getLogger().info("Plugin has been enabled.");
        getCommand("name").setExecutor(new command());
        getServer().getPluginManager().registerEvents(new onJoinEvent(), this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled.");
    }

}
