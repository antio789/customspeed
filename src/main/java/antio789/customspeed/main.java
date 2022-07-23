package antio789.customspeed;

import antio789.customspeed.config.ModConfig;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.World;


public class main implements ModInitializer {
    public static final String modid = "customspeed";
    public MinecraftServer World;

    public void setWorld(MinecraftServer world) {
        World =world;
        System.out.println("server initiated ////////////////////////////////");
    }

    @Override
    public void onInitialize() {
        ModConfig.init();
        ServerLifecycleEvents.SERVER_STARTED.register(this::setWorld);
        /*
        CommandRegistrationCallback.EVENT.register((dispatcher, registryAccess, environment) -> {
            dispatcher.register(CommandManager.literal("testing").executes(context -> {
                System.out.println(ModConfig.getTestnumber());
                return 1;
            }));
        });*/
    }




}
