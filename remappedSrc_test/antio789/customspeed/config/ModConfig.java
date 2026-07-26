package antio789.customspeed.config;


import antio789.customspeed.main;
import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.Util;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.GameRules;
import java.util.Map;

public class ModConfig {
    public ModConfig(){
    }


    private static final int villager_adult = 150;
    private static final int villager_baby = 600;
    private static final int animal_adult = 150;
    private static final int animal_baby = 600;
    private static final int spawnerspeed = 20;
    private static final int allayduplication = 300;
    public static int getAllayduplication(){return getspeed(Allayduplication)*20;}
    public static int getMinspawndelay() {
        return (getspeed(Spawnerspeed)/2)*20;
    }

    public static int getMaxspawndelay() {
        return (getspeed(Spawnerspeed)*2)*20;
    }


    public static int getVillager_adult() { return getspeed(Villager_breed)*20;
    }

    public static int getVillager_baby() {
        return -getspeed(Villager_baby)*20;
    }

    public static int getAnimal_adult() {
        return getspeed(Animal_breed)*20;
    }

    public static int getAnimal_baby() {
        return -getspeed(Animal_baby)*20;
    }

    public static final GameRules.Key<GameRules.IntegerValue> Villager_breed = GameRuleRegistry.register(main.modid+".adultvillagerbreed_150", GameRules.Category.MOBS, GameRuleFactory.createIntRule(villager_adult));
    public static final GameRules.Key<GameRules.IntegerValue> Villager_baby = GameRuleRegistry.register(main.modid+".babyvillagergrowup_600", GameRules.Category.MOBS, GameRuleFactory.createIntRule(villager_baby));
    public static final GameRules.Key<GameRules.IntegerValue> Animal_breed = GameRuleRegistry.register(main.modid+".adultanimalbreed_150", GameRules.Category.MOBS, GameRuleFactory.createIntRule(animal_adult));
    public static final GameRules.Key<GameRules.IntegerValue> Animal_baby = GameRuleRegistry.register(main.modid+".babyanimalgrowup_600", GameRules.Category.MOBS, GameRuleFactory.createIntRule(animal_baby));
    public static final GameRules.Key<GameRules.IntegerValue> Spawnerspeed = GameRuleRegistry.register(main.modid+".spawnerspeed_20", GameRules.Category.MOBS, GameRuleFactory.createIntRule(spawnerspeed));
    public static final GameRules.Key<GameRules.IntegerValue> Allayduplication = GameRuleRegistry.register(main.modid+".allayduplication_300", GameRules.Category.MOBS, GameRuleFactory.createIntRule(allayduplication));

    public static GameRules getRule(){
        return world.getGameRules();
    }
    public static int getspeed(GameRules.Key<GameRules.IntegerValue> rule){
        try {
            if (getRule().getInt(rule) < 1) {
                System.out.println("error value is lower than 1 please change");
                return defaults.get(rule);
            }
            return getRule().getInt(rule);
        }
        catch(Exception e){
            System.out.println("error world not loaded: " + e);
        }
        return defaults.get(rule);
    }



    private static final Map<GameRules.Key<GameRules.IntegerValue>, Integer> defaults = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(Villager_breed,villager_adult);
        hashMap.put(Villager_baby, villager_baby);
        hashMap.put(Animal_breed,animal_adult);
        hashMap.put(Animal_baby,animal_baby);
        hashMap.put(Spawnerspeed,spawnerspeed);
        hashMap.put(Allayduplication,allayduplication);
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
