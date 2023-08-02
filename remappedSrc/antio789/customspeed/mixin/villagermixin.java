package antio789.customspeed.mixin;


import net.minecraft.entity.ai.brain.task.VillagerBreedTask;
import net.minecraft.world.chunk.WorldChunk;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static antio789.customspeed.config.ModConfig.*;

@Mixin(VillagerBreedTask.class)
public abstract class villagermixin {
    @ModifyArg(method = "createChild",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/VillagerEntity;setBreedingAge(I)V"),index = 0)
    private int setAge(int par1){
        if(par1==6000){
            return getVillager_adult();
        }else if(par1==-24000){
            return getVillager_baby();
        }
        return par1;
    }
}
