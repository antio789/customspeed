package antio789.customspeed.mixin;

import antio789.customspeed.config.ModConfig;
import net.minecraft.world.entity.AgeableMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(AgeableMob.class)
public abstract class BabyAnimalTimer {

    @ModifyArg(method = "setBaby",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/AgeableMob;setAge(I)V"),index = 0)
    private int setAge(int par1){
        if(par1<0)return ModConfig.getAnimal_baby();
        return par1;
    }



}
