package antio789.customspeed.mixin;

import antio789.customspeed.config.ModConfig;
import net.minecraft.entity.ai.brain.task.VillagerBreedTask;
import net.minecraft.entity.passive.VillagerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(VillagerBreedTask.class)
public abstract class villagermixin {
    @ModifyArg(method = "createChild",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/VillagerEntity;setBreedingAge(I)V"),index = 0)
    private int setAge(int par1){
        if(par1==6000){
            return ModConfig.getVillager_adult();
        }else if(par1==-24000){
            return ModConfig.getVillager_baby();
        }
        return par1;
    }
}
