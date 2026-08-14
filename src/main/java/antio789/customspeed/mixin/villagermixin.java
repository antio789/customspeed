package antio789.customspeed.mixin;


import net.minecraft.world.entity.ai.behavior.VillagerMakeLove;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

import static antio789.customspeed.config.csGameRules.*;

@Mixin(VillagerMakeLove.class)
public abstract class villagermixin {
    @ModifyArg(method = "breed",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/npc/villager/Villager;setAge(I)V"),index = 0)
    private int setAge(int par1){
        if(par1==6000){
            return getVillager_adult();
        }else if(par1==-24000){
            return getVillager_baby();
        }
        return par1;
    }
}
