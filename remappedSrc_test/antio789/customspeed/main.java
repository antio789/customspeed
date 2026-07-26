package antio789.customspeed;

import antio789.customspeed.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;


public class main implements ModInitializer {
    public static final String modid = "customspeed";


    @Override
    public void onInitialize() {
        ModConfig.init();
        ServerWorldEvents.LOAD.register(ModConfig::setWorld);
        /*
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("testing").executes(context -> {
                System.out.println(ModConfig.getTestnumber());
                return 1;
            }));
        });*/
    }




}
