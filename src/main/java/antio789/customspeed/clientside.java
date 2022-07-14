package antio789.customspeed;



import me.lortseam.completeconfig.gui.ConfigScreenBuilder;
import me.lortseam.completeconfig.gui.coat.CoatScreenBuilder;
import net.fabricmc.api.ClientModInitializer;

public class clientside implements ClientModInitializer {
    public ConfigScreenBuilder<?> create() {
        return new CoatScreenBuilder();
    }
    ConfigScreenBuilder screenBuilder = new CoatScreenBuilder();

    @Override
    public void onInitializeClient() {
        main.config.load();

        ConfigScreenBuilder.setMain(main.modid, create());
    }
}
