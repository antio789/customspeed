package antio789.customspeed.config;

import antio789.customspeed.main;
import me.lortseam.completeconfig.api.ConfigEntry;
import me.lortseam.completeconfig.data.Config;
import me.lortseam.completeconfig.data.ConfigOptions;

public class ModConfig extends Config {
    public ModConfig(){
        super(ConfigOptions.mod(main.modid));
    }

    public static int getTestnumber() {
        return testnumber;
    }



    @ConfigEntry.BoundedInteger(min = 1, max = 1000000)
    private static int testnumber = 60;

    @ConfigEntry(comment = "time for a villager to mate again in seconds: 150 default")
    @ConfigEntry.BoundedInteger(min = 1, max = 1000000)
    private static int villager_adult = 150;
    @ConfigEntry(comment = "time for a baby villager to grow up in seconds: 600 default")
    @ConfigEntry.BoundedInteger(min = 1, max = 1000000)
    private static int villager_baby = 600;
    @ConfigEntry(comment = "time for an animal to mate again in seconds: 150 default")
    @ConfigEntry.BoundedInteger(min = 1, max = 1000000)
    private static int animal_adult = 150;
    @ConfigEntry(comment = "time for a baby animal to grow up in seconds: 600 default")
    @ConfigEntry.BoundedInteger(min = 1, max = 1000000)
    private static int animal_baby = 600;


    @ConfigEntry(comment = "average time for mob spawning in seconds: default 20")
    @ConfigEntry.BoundedInteger(min = 2, max = 1000000)
    private static int spawnerspeed = 20;

    public static int getMinspawndelay() {
        return (spawnerspeed/2)*20;
    }

    public static int getMaxspawndelay() {
        return (spawnerspeed*2)*20;
    }

    public static int getVillager_adult() {
        return villager_adult*20;
    }

    public static int getVillager_baby() {
        return -villager_baby*20;
    }

    public static int getAnimal_adult() {
        return animal_adult*20;
    }

    public static int getAnimal_baby() {
        return -animal_baby*20;
    }







}
