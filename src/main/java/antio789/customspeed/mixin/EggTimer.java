package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.projectile.thrown.EggEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(EggEntity.class)
public abstract class EggTimer {
    @ModifyArg(method = "onCollision(Lnet/minecraft/util/hit/HitResult;)V",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/passive/ChickenEntity;setBreedingAge(I)V"),index = 0)
    private int init(int par1){
        return ModConfig.getAnimal_baby();
    }
}
