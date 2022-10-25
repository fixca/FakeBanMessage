package me.fixca.fakeban.main;

import me.fixca.fakeban.commands.FakeBanCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class FakeBan extends JavaPlugin {

    @Override
    public void onEnable() {
        init();
    }

    @Override
    public void onDisable() {

    }

    private void init() {
        loadCommands();
    }

    private void loadCommands() {
        getCommand("fakeban").setExecutor(new FakeBanCommand());
    }

}
