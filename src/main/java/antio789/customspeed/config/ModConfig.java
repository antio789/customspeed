package antio789.customspeed.config;


import antio789.customspeed.main;
import com.google.common.collect.Maps;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;
import java.util.Map;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleBuilder;
import net.minecraft.world.level.gamerules.GameRule;
import net.minecraft.world.level.gamerules.GameRuleCategory;
import net.minecraft.world.level.gamerules.GameRules;

public class ModConfig {
    public ModConfig(){
    }

    private static final int villager_adult = 150;
    private static final int villager_baby = 600;
    private static final int animal_adult = 150;
    private static final int animal_baby = 600;
    private static final int spawner_speed = 20;
    private static final int allay_duplication = 300;
    private static final int turtle_crackchance = 500;

    public static final GameRule<Integer> Villager_breed =
            GameRuleBuilder.forInteger(villager_adult)
                    .range(1, 10000)
                    .category(GameRuleCategory.MOBS)
                    .buildAndRegister(Identifier.fromNamespaceAndPath(main.modid, "adultvillagerbreed_150"));

    public static final GameRule<Integer> Villager_baby =
            GameRuleBuilder.forInteger(villager_baby)
                    .range(1, 10000)
                    .category(GameRuleCategory.MOBS)
                    .buildAndRegister(Identifier.fromNamespaceAndPath(main.modid, "babyvillagergrowup_600"));

    public static final GameRule<Integer> Animal_breed =
            GameRuleBuilder.forInteger(animal_adult)
                    .range(1, 10000)
                    .category(GameRuleCategory.MOBS)
                    .buildAndRegister(Identifier.fromNamespaceAndPath(main.modid, "adultanimalbreed_150"));

    public static final GameRule<Integer> Animal_baby =
            GameRuleBuilder.forInteger(animal_baby)
                    .range(1, 10000)
                    .category(GameRuleCategory.MOBS)
                    .buildAndRegister(Identifier.fromNamespaceAndPath(main.modid, "babyanimalgrowup_600"));

    public static final GameRule<Integer> Spawnerspeed =
            GameRuleBuilder.forInteger(spawner_speed)
                    .range(2, 10000)
                    .category(GameRuleCategory.MOBS)
                    .buildAndRegister(Identifier.fromNamespaceAndPath(main.modid, "spawnerspeed_20"));

    public static final GameRule<Integer> Allayduplication =
            GameRuleBuilder.forInteger(allay_duplication)
                    .range(1, 10000)
                    .category(GameRuleCategory.MOBS)
                    .buildAndRegister(Identifier.fromNamespaceAndPath(main.modid, "allayduplication_300"));

    public static final GameRule<Integer> TurtleCrackChance =
            GameRuleBuilder.forInteger(turtle_crackchance)
                    .range(1, 10000)
                    .category(GameRuleCategory.MOBS)
                    .buildAndRegister(Identifier.fromNamespaceAndPath(main.modid, "turtlecrackchance_500"));

    public static int getMinspawndelay() {
        return (getspeed(Spawnerspeed)/2)*20;
    }
    public static int getMaxspawndelay() {
        return (getspeed(Spawnerspeed)*2)*20;
    }

    public static int getVillager_adult() { return getspeed(Villager_breed)*20;}
    public static int getVillager_baby() {
        return -getspeed(Villager_baby)*20;
    }
    public static int getAnimal_adult() {
        return getspeed(Animal_breed)*20;
    }
    public static int getAnimal_baby() {
        return -getspeed(Animal_baby)*20;
    }

    public static int getAllay_duplication(){return getspeed(Allayduplication)*20;}
    public static float getTurtleCrackChance(){return 1.0f/getspeed(TurtleCrackChance);}

    public static GameRules getRule(){
        return world.getGameRules();
    }
    public static int getspeed(GameRule<Integer> rule){
        try {
            if (getRule().get(rule) < 1) {
                System.out.println("error value is lower than 1 please change");
                return defaults.get(rule);
            }
            return getRule().get(rule);
        }
        catch(Exception e){
            System.out.println("error world not loaded: " + e);
        }
        return defaults.get(rule);
    }



    private static final Map<GameRule<Integer>, Integer> defaults = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(Villager_breed,villager_adult);
        hashMap.put(Villager_baby, villager_baby);
        hashMap.put(Animal_breed,animal_adult);
        hashMap.put(Animal_baby,animal_baby);
        hashMap.put(Spawnerspeed, spawner_speed);
        hashMap.put(Allayduplication, allay_duplication);
        hashMap.put(TurtleCrackChance, turtle_crackchance);
    });


/** gamerules work only on int and bool unfortunately this would be for later
    private enum GameSpeed{
        VERY_FAST,
        FAST,
        NORMAL,
        SLOW,
        VERY_SLOW
    }

    private static final Map<GameSpeed, Double> CONFIGSPEED = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(GameSpeed.VERY_FAST,0.25);
        hashMap.put(GameSpeed.FAST, 0.5);
        hashMap.put(GameSpeed.NORMAL, 1.0);
        hashMap.put(GameSpeed.SLOW,2.0);
        hashMap.put(GameSpeed.VERY_SLOW,4.0);
    });
*/


    public static void init() {
    }

public static ServerLevel world;
    public static void setWorld(MinecraftServer minecraftServer, ServerLevel serverWorld) {
        world=serverWorld;
    }
}
