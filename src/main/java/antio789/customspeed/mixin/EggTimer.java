package antio789.customspeed.mixin;


import antio789.customspeed.config.ModConfig;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEgg;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;


@Mixin(ThrownEgg.class)
public abstract class EggTimer {
    // TODO(Ravel): no target class
    @ModifyArg(method = "onHit(Lnet/minecraft/world/phys/HitResult;)V",at = @At(value = "INVOKE",target = "Lnet/minecraft/world/entity/animal/chicken/Chicken;setAge(I)V"),index = 0)
    private int init(int par1){
        return ModConfig.getAnimal_baby();
    }
}
