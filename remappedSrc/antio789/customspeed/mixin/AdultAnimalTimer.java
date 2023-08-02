package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.entity.passive.AnimalEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(AnimalEntity.class)
public abstract class AdultAnimalTimer {
    @ModifyArg(method = "breed(Lnet/minecraft/server/world/ServerWorld;Lnet/minecraft/entity/passive/AnimalEntity;Lnet/minecraft/entity/passive/PassiveEntity;)V",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/AnimalEntity;setBreedingAge(I)V"),index = 0)
    private int init(int par1){
        return ModConfig.getAnimal_adult();
    }




}
