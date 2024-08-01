package antio789.customspeed.mixin;

import antio789.customspeed.config.ModConfig;
import net.minecraft.entity.passive.PassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PassiveEntity.class)
public abstract class BabyAnimalTimer {
    @Shadow public abstract boolean isBaby();

    @ModifyArg(method = "setBaby",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/PassiveEntity;setBreedingAge(I)V"),index = 0)
    private int setAge(int par1){
        if(par1<0)return ModConfig.getAnimal_baby();
        return par1;
    }



}
