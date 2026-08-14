package antio789.customspeed;

import antio789.customspeed.config.csGameRules;
import com.mojang.logging.LogUtils;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.gamerules.*;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.neoforged.neoforge.registries.RegisterEvent;
import org.slf4j.Logger;


@Mod(customspeed.MODID)
public class customspeed{
    public static final String MODID = "customspeed";

    public static final Logger LOGGER = LogUtils.getLogger();

    /**
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
        });
    }
    */
    public customspeed(IEventBus modEventBus, ModContainer modContainer) {

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::registerSetup);
        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (customspeed) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        NeoForge.EVENT_BUS.register(this);


        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, csGameRules.SPEC);
    }


    public void registerSetup(RegisterEvent event) {
        LOGGER.info("HELLO FROM registerevents");
        if (event.getRegistry().equals(BuiltInRegistries.GAME_RULE)) {
            LOGGER.info("HELLO FROM registerevents 2");
            // Register game rules
            csGameRules.Villager_breed = GameRules.registerInteger(
                    Identifier.fromNamespaceAndPath(MODID, "adultvillagerbreed_150").toString(),
                    GameRuleCategory.MOBS, csGameRules.villager_adult, 1);

            csGameRules.Villager_baby = GameRules.registerInteger(
                    Identifier.fromNamespaceAndPath(MODID, "babyvillagergrowup_600").toString(),
                    GameRuleCategory.MOBS, csGameRules.villager_baby, 1);

            csGameRules.Animal_breed = GameRules.registerInteger(
                    Identifier.fromNamespaceAndPath(MODID, "adultanimalbreed_150").toString(),
                    GameRuleCategory.MOBS, csGameRules.animal_adult, 1);

            csGameRules.Animal_baby = GameRules.registerInteger(
                    Identifier.fromNamespaceAndPath(MODID, "babyanimalgrowup_600").toString(),
                    GameRuleCategory.MOBS, csGameRules.animal_baby, 1);

            csGameRules.Spawnerspeed = GameRules.registerInteger(
                    Identifier.fromNamespaceAndPath(MODID, "spawnerspeed_20").toString(),
                    GameRuleCategory.MOBS, csGameRules.spawner_speed, 1);

            csGameRules.Allayduplication = GameRules.registerInteger(
                    Identifier.fromNamespaceAndPath(MODID, "allayduplication_300").toString(),
                    GameRuleCategory.MOBS, csGameRules.allay_duplication, 1);

            csGameRules.TurtleCrackChance = GameRules.registerInteger(
                    Identifier.fromNamespaceAndPath(MODID, "turtlecrackchance_500").toString(),
                    GameRuleCategory.MOBS, csGameRules.turtle_crackchance, 1);
        }
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Some common setup code
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        csGameRules.setWorld(event.getServer(),event.getServer().overworld());
    }





}
