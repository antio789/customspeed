package antio789.customspeed;

import antio789.customspeed.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;

import net.minecraft.resources.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class main implements ModInitializer {
    public static final String modid = "customspeed";

    public static final Logger LOGGER = LoggerFactory.getLogger(modid);


    @Override
    public void onInitialize() {
        ModConfig.init();
        ServerLifecycleEvents.SERVER_STARTED.register(server -> {ModConfig.setWorld(server,server.overworld());});
        /*
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("testing").executes(context -> {
                System.out.println(ModConfig.getTestnumber());
                return 1;
            }));
        });*/

    }
    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(modid, path);
    }




}
