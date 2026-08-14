package antio789.customspeed.config;


import com.google.common.collect.Maps;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Util;
import net.minecraft.world.level.gamerules.*;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.Map;

public class csGameRules {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC = BUILDER.build();
    public csGameRules(){
    }
    public static void init() {
    }
    public static final int villager_adult = 150;
    public static final int villager_baby = 600;
    public static final int animal_adult = 150;
    public static final int animal_baby = 600;
    public static final int spawner_speed = 20;
    public static final int allay_duplication = 300;
    public static final int turtle_crackchance = 500;

    public static GameRule<Integer> Villager_breed;
    public static GameRule<Integer> Villager_baby;
    public static GameRule<Integer> Animal_breed;
    public static GameRule<Integer> Animal_baby;
    public static GameRule<Integer> Spawnerspeed;
    public static GameRule<Integer> Allayduplication;
    public static GameRule<Integer> TurtleCrackChance;

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


public static ServerLevel world;
    public static void setWorld(MinecraftServer minecraftServer, ServerLevel serverWorld) {
        world=serverWorld;
    }
}
