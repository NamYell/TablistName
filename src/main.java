import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin {

    public static DataManager data;

    @Override
    public void onEnable() {

        data = new DataManager(this);

        if (data.getConfig().contains("data")) {
            event.loadName();
        }

        getLogger().info("Plugin has been enabled.");
        getCommand("name").setExecutor(new command());
    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been disabled.");
    }

}
