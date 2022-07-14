package antio789.customspeed;

import antio789.customspeed.config.ModConfig;
import net.fabricmc.api.ModInitializer;



public class main implements ModInitializer {
    public static final String modid = "customspeed";

    static ModConfig config = new ModConfig();


    @Override
    public void onInitialize() {
        config.load();
        /*
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("testing").executes(context -> {
                System.out.println(ModConfig.getTestnumber());
                return 1;
            }));
        });*/
    }




}
