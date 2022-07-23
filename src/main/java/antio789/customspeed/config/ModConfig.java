package antio789.customspeed.config;


import antio789.customspeed.main;
import com.google.common.collect.Maps;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.Util;
import net.minecraft.world.GameRules;

import java.util.Map;
import java.util.Objects;

public class ModConfig {
    public ModConfig(){
    }

    public static MinecraftServer World;

    public static void setWorld(MinecraftServer world) {
        World =world;
    }


    private static final int villager_adult = 150;
    private static final int villager_baby = 600;
    private static final int animal_adult = 150;
    private static final int animal_baby = 600;
    private static final int spawnerspeed = 20;

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

    public static final GameRules.Key<GameRules.IntRule> Villager_breed = GameRuleRegistry.register(main.modid+".adultVillagerbreed_150", GameRules.Category.MOBS, GameRuleFactory.createIntRule(villager_adult));
    public static final GameRules.Key<GameRules.IntRule> Villager_baby = GameRuleRegistry.register(main.modid+".babyVillagergrowup_600", GameRules.Category.MOBS, GameRuleFactory.createIntRule(villager_baby));
    public static final GameRules.Key<GameRules.IntRule> Animal_breed = GameRuleRegistry.register(main.modid+".adultAnimalbreed_150", GameRules.Category.MOBS, GameRuleFactory.createIntRule(animal_adult));
    public static final GameRules.Key<GameRules.IntRule> Animal_baby = GameRuleRegistry.register(main.modid+".babyAnimalgrowup_600", GameRules.Category.MOBS, GameRuleFactory.createIntRule(animal_baby));
    public static final GameRules.Key<GameRules.IntRule> Spawnerspeed = GameRuleRegistry.register(main.modid+".Spawnerspeed_20", GameRules.Category.MOBS, GameRuleFactory.createIntRule(spawnerspeed));

    public static GameRules getRule(){
        return Objects.requireNonNull(MinecraftClient.getInstance().getServer()).getGameRules();
    }
    public static int getspeed(GameRules.Key<GameRules.IntRule> rule){
        if(MinecraftClient.getInstance().getServer()==null||getRule().getInt(rule)<1){
            return defaults.get(rule);
        }
        return getRule().getInt(rule);
    }



    private static final Map<GameRules.Key, Integer> defaults = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(Villager_breed,villager_adult);
        hashMap.put(Villager_baby, villager_baby);
        hashMap.put(Animal_breed,animal_adult);
        hashMap.put(Animal_baby,animal_baby);
        hashMap.put(Spawnerspeed,spawnerspeed);
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


}
