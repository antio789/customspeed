package antio789.customspeed.config;


import antio789.customspeed.customspeed;
import com.google.common.collect.Maps;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Util;
import java.util.Map;

import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.level.gamerules.*;
import net.neoforged.neoforge.common.ModConfigSpec;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModConfig {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();
    public static final ModConfigSpec SPEC = BUILDER.build();
    public ModConfig(){
    }

    private static final int villager_adult = 150;
    private static final int villager_baby = 600;
    private static final int animal_adult = 150;
    private static final int animal_baby = 600;
    private static final int spawner_speed = 20;
    private static final int allay_duplication = 300;
    private static final int turtle_crackchance = 500;

    public static final DeferredRegister<GameRule<?>> GAME_RULES =
            DeferredRegister.create(BuiltInRegistries.GAME_RULE, customspeed.MODID);

    public static final DeferredHolder<GameRule<?>, GameRule<Integer>> Villager_breed =
            GAME_RULES.register("adultvillagerbreed_150", () ->
                    createIntGameRule(villager_adult)
            );

    public static final DeferredHolder<GameRule<?>, GameRule<Integer>> Villager_baby =
            GAME_RULES.register("babyvillagergrowup_600", () ->
                    createIntGameRule(villager_baby)
            );

    public static final DeferredHolder<GameRule<?>, GameRule<Integer>> Animal_breed =
            GAME_RULES.register("adultanimalbreed_150", () ->
                    createIntGameRule(animal_adult)
            );

    public static final DeferredHolder<GameRule<?>, GameRule<Integer>> Animal_baby =
            GAME_RULES.register("babyanimalgrowup_600", () ->
                    createIntGameRule(animal_baby)
            );

    public static final DeferredHolder<GameRule<?>, GameRule<Integer>> Spawnerspeed =
            GAME_RULES.register("spawnerspeed_20", () ->
                    createIntGameRule(spawner_speed)
            );

    public static final DeferredHolder<GameRule<?>, GameRule<Integer>> Allayduplication =
            GAME_RULES.register("allayduplication_300", () ->
                    createIntGameRule(allay_duplication)
            );

    public static final DeferredHolder<GameRule<?>, GameRule<Integer>> TurtleCrackChance =
            GAME_RULES.register("turtlecrackchance_500", () ->
                    createIntGameRule(turtle_crackchance)
            );

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
    public static int getspeed(DeferredHolder<GameRule<?>,net.minecraft.world.level.gamerules.GameRule<java.lang.Integer>> rule){
        try {
            if (getRule().get(rule.get()) < 1) {
                System.out.println("error value is lower than 1 please change");
                return defaults.get(rule);
            }
            return getRule().get(rule.get());
        }
        catch(Exception e){
            System.out.println("error world not loaded: " + e);
        }
        return defaults.get(rule);
    }


    private static GameRule<Integer> createIntGameRule(int defaultValue) {
        return new GameRule<>(
                GameRuleCategory.MOBS,
                GameRuleType.INT,
                IntegerArgumentType.integer(1, Integer.MAX_VALUE),
                GameRuleTypeVisitor::visitInteger,
                Codec.intRange(1, Integer.MAX_VALUE),
                p -> p,
                defaultValue,
                FeatureFlagSet.of()
        );
    }




    private static final Map<GameRule<Integer>, Integer> defaults = Util.make(Maps.newHashMap(), hashMap -> {
        hashMap.put(Villager_breed.get(),villager_adult);
        hashMap.put(Villager_baby.get(), villager_baby);
        hashMap.put(Animal_breed.get(),animal_adult);
        hashMap.put(Animal_baby.get(),animal_baby);
        hashMap.put(Spawnerspeed.get(), spawner_speed);
        hashMap.put(Allayduplication.get(), allay_duplication);
        hashMap.put(TurtleCrackChance.get(), turtle_crackchance);
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
