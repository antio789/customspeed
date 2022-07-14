package antio789.customspeed.mixin;

import antio789.customspeed.config.ModConfig;
import net.minecraft.entity.passive.PassiveEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(PassiveEntity.class)
public abstract class BabyAnimalTimer {
    @ModifyArg(method = "setBaby",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/PassiveEntity;setBreedingAge(I)V"),index = 0)
    private int setAge(int par1){
        return ModConfig.getAnimal_baby();
    }



}
